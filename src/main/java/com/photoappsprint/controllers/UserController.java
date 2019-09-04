package com.photoappsprint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoappsprint.model.User;
import com.photoappsprint.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{id}")
	public User get(@PathVariable("id") int id) {
		return userService.get(id);
	}
	
	@GetMapping(value="/list")
	public List<User> list(){
		return userService.list();
	}
	
}
