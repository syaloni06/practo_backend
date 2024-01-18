package com.springboot.practo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practo.Entities.AdminLogin;
import com.springboot.practo.services.AdminLoginService;



@RestController
@RequestMapping("/api/admin_login")
public class AdminLoginController {
	
	@Autowired
	AdminLoginService adminLoginService;
	
	@PostMapping("/signup")
	public String createAdminAccount(@RequestBody AdminLogin adminLogin) {
		return adminLoginService.signup(adminLogin);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody AdminLogin adminLogin) {
		return adminLoginService.login(adminLogin.getAdmin_email_id(),adminLogin.getPassword());
	}


}
