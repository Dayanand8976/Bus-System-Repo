package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Login;
import com.lti.dto.LoginStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity.User;
import com.lti.exception.CustomerServiceException;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public RegisterStatus register(@RequestBody User user) {
		try {
			int id=userService.register(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(true);
			status.setMessage("Registration sucessful");
			status.setRegisteredUserId(id);
			return status;
		}
		catch(CustomerServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			User user = userService.login(login.getEmail(), login.getPassword());
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(true);
			loginStatus.setMessage("Login successful!");
			loginStatus.setUserId(user.getId());
			loginStatus.setFirstName(user.getFirstName());
			loginStatus.setLastName(user.getLastName());
			return loginStatus;
		}
		catch(CustomerServiceException e) {
			LoginStatus loginStatus = new LoginStatus();
			loginStatus.setStatus(false);
			loginStatus.setMessage(e.getMessage());		
			return loginStatus;
		}
	}
	
	
}
