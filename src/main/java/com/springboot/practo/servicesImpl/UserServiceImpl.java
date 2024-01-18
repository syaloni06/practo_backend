package com.springboot.practo.servicesImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.springboot.practo.Entities.User;
import com.springboot.practo.repositories.UserRepository;
import com.springboot.practo.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;


	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long user_id) {
		return userRepository.findById(user_id).get();
	}
	
	

	@Override
	public User updateUser(Long user_id, User user) {
		User u = userRepository.findById(user_id).get();
		u.setUser_name(user.getUser_name());
		u.setMobile(user.getMobile());
		return userRepository.save(u);
	}

	@Override
	public String deleteUser(Long user_id) {
		userRepository.deleteById(user_id);
		return "Your record has been deleted!";
	}
	
	@Override
	public ResponseEntity<String> signup(User user) {
		try {
			if(userRepository.findByEmail_id(user.getEmail_id()).get()!=null) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your already have an account, Please login");
			}
			
		}catch(NoSuchElementException e) {
			e.getMessage();
			
		}
		userRepository.save(user);
		return ResponseEntity.ok("Your accont have been created");
	}

	@Override
	public ResponseEntity<String> login(String email_id, String password) {
		try {
			User u = userRepository.findByEmail_id(email_id).get();
			System.out.println(u.getPassword());
			if(password.equals(u.getPassword())) {
				return ResponseEntity.ok("You have logged in successfully.");
			}
			else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Password");
			}	
		}
			catch(NoSuchElementException e){
				e.getMessage();
			}
			
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not Registered, Please register Yourself");
	}

	@Override
	public User findByEmail(String email_id) {
		try {
			User u = userRepository.findByEmail_id(email_id).get();
			
			return u;
			
		}
			catch(NoSuchElementException e){
				e.getMessage();
			}
		return null;
	}


}
