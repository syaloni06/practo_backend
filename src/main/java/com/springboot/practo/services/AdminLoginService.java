package com.springboot.practo.services;

import com.springboot.practo.Entities.AdminLogin;

public interface AdminLoginService {
	public String signup(AdminLogin adminLogin);
	public String login(String admin_email_id, String password);
}
