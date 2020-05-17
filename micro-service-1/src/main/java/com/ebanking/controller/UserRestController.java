package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.User;
import com.ebanking.service.IUserService;

@RestController
public class UserRestController {

	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		
		return iUserService.saveUser(user);
		
	}
}
