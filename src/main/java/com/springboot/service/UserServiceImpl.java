package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.customexception.ResourceNotFound;
import com.springboot.model.User;
import com.springboot.repositories.UserRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User findById(Long id) throws ResourceNotFound {
		// TODO Auto-generated method stub
		userRepository.findById(id);
		return null;
	}

	@Override
	public User findByName(String name) throws ResourceNotFound {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean deleteById(Long id) throws ResourceNotFound {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		return false;
	}

	@Override
	public boolean UpdateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);
		return false;
	}

	@Override
	public boolean saveUser(User user) throws ResourceNotFound {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);
		return false;
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
	}

	@Override
	public boolean DeleteAllUsers() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean IsUserExist(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
