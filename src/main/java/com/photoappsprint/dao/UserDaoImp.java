package com.photoappsprint.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import com.photoappsprint.model.User;

@Repository
public class UserDaoImp implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User get(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = cBuilder.createQuery(User.class);
		Root<User> root = cQuery.from(User.class);
		cQuery.select(root);
		Query<User> query = session.createQuery(cQuery);
		return query.getResultList();
	}

	@Override
	public int save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public void update(int id, User user) {
		Session session = sessionFactory.getCurrentSession();
		User user2 = session.byId(User.class).load(id);
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setLocation(user.getLocation());
		user2.setDescription(user.getDescription());
		user2.setOccupation(user.getOccupation());
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
	}

}
