package com.ebanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanking.model.Role;
import com.ebanking.model.User;
import com.ebanking.repository.RoleRepository;
import com.ebanking.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements IUserService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User saveUser(User user) {
		String cryptPass=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(cryptPass);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		Role role=roleRepository.findByRole(roleName);
		User user=userRepository.findByUsername(username);
		user.getRoles().add(role);

	}

	@Override
	public User findUserByUsername(String username) { 
		return userRepository.findByUsername(username);
	}

}
