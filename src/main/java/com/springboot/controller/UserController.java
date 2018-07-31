package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.customexception.ResourceNotFound;
import com.springboot.model.User;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// get single user by id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {

		try {
			User user = userService.findById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (ResourceNotFound e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

	}

	// get All users
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> list_users = userService.findAll();
			if (!(list_users.isEmpty()))
				return new ResponseEntity<List<User>>(list_users, HttpStatus.OK);
			else
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable(value = "id") Long id) {
		User user = null;
		try {
		user = userService.findById(id);
		} catch (ResourceNotFound e) {
			return new ResponseEntity<User>( HttpStatus.NOT_FOUND);
		}
		userService.deleteById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Delete All users
	@DeleteMapping("/delete/all")
	public ResponseEntity<User> deleteAllUsers() throws Exception {

		userService.DeleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// update user
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		User currentUser;
		try {
			currentUser = userService.findById(id);
		} catch (ResourceNotFound ex) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		try {
			currentUser.setAge(user.getAge());
			currentUser.setEmail(user.getEmail());
			currentUser.setName(user.getName());
			currentUser.setRoleId(user.getRoleId());
			currentUser.setSalary(user.getSalary());
			userService.UpdateUser(currentUser);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// create user
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
	}

}
