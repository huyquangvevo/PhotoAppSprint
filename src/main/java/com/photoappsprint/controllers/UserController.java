package com.photoappsprint.controllers;

import javax.jws.WebParam.Mode;
import javax.naming.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.photoappsprint.dao.UserDAO;
import com.photoappsprint.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@GetMapping("")
	public ModelAndView getUserList() {
		ModelAndView modelAndView = new ModelAndView("UserList");
		modelAndView.addObject("userList",userDAO.userListModel());
		return modelAndView;
	}
	
	@GetMapping("/{userId}")
	public ModelAndView getUserDetail(@PathVariable int userId) {
		ModelAndView modelAndView = new ModelAndView("UserDetail");
		modelAndView.addObject("user", userDAO.userModel(userId));
		return modelAndView;
	}
	
}
