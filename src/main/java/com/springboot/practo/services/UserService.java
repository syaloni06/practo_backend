package com.springboot.practo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.practo.Entities.User;

public interface UserService {
	
	List<User> getAll();
	User findById(Long user_id);
	User findByEmail(String email);
	User updateUser(Long user_id, User user);
	String deleteUser(Long user_id);
	ResponseEntity<String> signup(User user);
	ResponseEntity<String> login(String email_id,String password);
	
}

