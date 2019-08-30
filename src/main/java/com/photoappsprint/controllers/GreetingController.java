package com.photoappsprint.controllers;

import java.awt.PageAttributes.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.photoappsprint.model.User;

@RestController
public class GreetingController {

	@GetMapping(path="/greeting")
	public User greeting(@RequestParam(value="userId",defaultValue="1") int userId) {
		User user = new User();
		user.setId(1);
		user.setFirstName("Huy");
		user.setLastName("Quang");
		user.setLocation("Hanoi");
		user.setOccupation("Software Engineer");
		user.setDescription("Bass music");
		return user;
	}
	
}
