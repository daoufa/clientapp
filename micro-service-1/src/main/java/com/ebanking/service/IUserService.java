package com.ebanking.service;

import com.ebanking.model.Role;
import com.ebanking.model.User;

public interface IUserService {

	public User saveUser(User user);
	public Role saveRole(Role role);
	public void addRoleToUser(String username,String roleName);
	public User findUserByUsername(String username);
}
