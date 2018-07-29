package com.springboot.service;

import java.util.List;

import com.springboot.model.User;
import com.springboot.customexception.*;

public interface UserService {

	User findById(Long id)  throws ResourceNotFound;
	
	User findByName(String name)  throws ResourceNotFound;
	
	boolean deleteById(Long id) throws ResourceNotFound;
	
	boolean UpdateUser(User user) throws Exception;
	
	boolean saveUser(User user) throws ResourceNotFound;
	
	List<User> findAll() throws Exception;
	
	boolean DeleteAllUsers() throws Exception;
	
	boolean IsUserExist(User user) throws Exception;
	
	
}
