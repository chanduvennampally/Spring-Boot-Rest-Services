package com.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.customexception.ResourceNotFound;
import com.springboot.model.User;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// get single user by id

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
		
		try {
			User user = userService.findById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (ResourceNotFound e) {
			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}
		
	}
}
