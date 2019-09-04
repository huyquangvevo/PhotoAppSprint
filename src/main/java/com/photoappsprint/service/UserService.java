package com.photoappsprint.service;

import java.util.List;

import org.ietf.jgss.Oid;

import com.photoappsprint.model.User;

public interface UserService {

	long save(User user);
	User get(int id);
	List<User> list();
	void update(int id, User user);
	void delete(int id);
	
}
