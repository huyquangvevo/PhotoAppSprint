package com.photoappsprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photoappsprint.dao.UserDao;
import com.photoappsprint.model.User;

@Service
@org.springframework.transaction.annotation.Transactional(readOnly=true)
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public long save(User user) {
		return userDao.save(user); 
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public void update(int id, User user) {
		userDao.update(id, user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
