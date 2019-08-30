package com.photoappsprint.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.photoappsprint.mapper.UserMapper;
import com.photoappsprint.model.User;

public class UserDAO extends JdbcDaoSupport {
	
	public List<User> userListModel() {
		String sql = "SELECT * FROM user";
		return this.getJdbcTemplate().query(sql, new UserMapper());
	}
	
	public User userModel(int id) {
		String sql = "SELECT * FROM user WHERE _id=?";
		return this.getJdbcTemplate().queryForObject(sql, new Object[] {id},new UserMapper());
	}
	
}




