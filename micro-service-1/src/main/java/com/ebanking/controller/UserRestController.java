package com.ebanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ebanking.model.Compte;
import com.ebanking.model.User;
import com.ebanking.repository.UserRepository;
import com.ebanking.service.IUserService;

@RestController
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		
		return iUserService.saveUser(user);
		
	}
	
	@GetMapping (value="/users/{username}")
	public User getUserByUsername(@PathVariable(name="username") String username){
		
		return userRepository.findByUsername(username);
	}
}
