package com.springboot.practo.servicesImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.practo.Entities.AdminLogin;
import com.springboot.practo.repositories.AdminLoginRepository;
import com.springboot.practo.services.AdminLoginService;
@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	AdminLoginRepository adminLoginRepository;

	@Override
	public String signup(AdminLogin adminLogin) {
		adminLoginRepository.save(adminLogin);
		return "Your accont have been created";
	}

	@Override
	public String login(String admin_email_id, String password) {
		try {
			AdminLogin al = adminLoginRepository.findById(admin_email_id).get();
			if(password.equals(al.getPassword())) {
				return "You have logged in successfully.";
			}
			else {
				return "Incorrect Password";
			}
		}
		catch(NoSuchElementException e) {
			e.getMessage();
		}
		return "Incorrect user_id, Please register Yourself";
	}

}
