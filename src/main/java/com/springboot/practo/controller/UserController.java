package com.springboot.practo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practo.Entities.User;
import com.springboot.practo.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@GetMapping("/show")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/find/{user_id}")
	public User findById(@PathVariable Long user_id) {
		return userService.findById(user_id);
	}
	
	@GetMapping("/findByEmail/{email}")
	public User findByEmail(@PathVariable String email) {
		return userService.findByEmail(email);
	}
	
	@PutMapping("/update/{user_id}")
	public User updateUser(@PathVariable Long user_id, @RequestBody User user) {
		return userService.updateUser(user_id, user);
	}
	
	@DeleteMapping("/delete/{user_id}")
	public String deleteUser(@PathVariable Long user_id) {
		return userService.deleteUser(user_id);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> createUserAccount(@RequestBody User user) {
		return userService.signup(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		return userService.login(user.getEmail_id(),user.getPassword());
	}
}
