package com.springboot.service;

import java.util.List;

import com.springboot.model.User;
import com.springboot.customexception.*;

public interface UserService {

	User findById(Long id)  throws ResourceNotFound;
	
	boolean deleteById(Long id) ;
	
	User UpdateUser(User user) throws Exception;
	
	User saveUser(User user) throws ResourceNotFound;
	
	List<User> findAll() throws Exception;
	
	void DeleteAllUsers() throws Exception;
	
	boolean IsUserExist(User user) throws Exception;
	
	
}
