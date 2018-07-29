package com.springboot.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.customexception.ResourceNotFound;
import com.springboot.model.User;
import com.springboot.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Long id) throws ResourceNotFound {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("User", "User ID", id));
	}

	@Override
	public boolean deleteById(Long id) {

		userRepository.delete(findById(id));
		return true;
	}

	@Override
	public User UpdateUser(User user) throws Exception {

		return userRepository.saveAndFlush(findById(user.getUserId()));
	}

	@Override
	public User saveUser(User user) throws ResourceNotFound {

		return userRepository.saveAndFlush(user);
	}

	@Override
	public List<User> findAll() throws Exception {

		return userRepository.findAll();
	}

	@Override
	public void DeleteAllUsers() throws Exception {

		userRepository.deleteAll();
	}

	@Override
	public boolean IsUserExist(User user) throws Exception {
		
		return userRepository.findById(user.getUserId()).isPresent();
	}

}
