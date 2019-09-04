package com.photoappsprint.dao;

import java.util.List;

import com.photoappsprint.model.User;

public interface UserDao {
	
	User get(int id);
	List<User> list();
	int save(User user);
	void update(int id,User user);
	void delete(int id);

}
