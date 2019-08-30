package com.photoappsprint.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.photoappsprint.dao.PhotoDAO;
import com.photoappsprint.dao.UserDAO;
import com.photoappsprint.model.Photo;

@Controller
@RequestMapping("/photos")
public class PhotosController {
	
	@Autowired
	PhotoDAO photoDao;
	@Autowired
	UserDAO userDao;

	@GetMapping("/{userId}")
	public ModelAndView getPhotoOfUserModel(@PathVariable int userId){
		ModelAndView modelAndView = new ModelAndView("UserPhotos");
		List<Photo> listPhoto = photoDao.getPhotoOfUser(userId);
		modelAndView.addObject("photos", listPhoto);
		modelAndView.addObject("user",userDao.userModel(userId));
		return modelAndView;
	}
	
}
