package com.auction.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.auction.model.User;

public interface UserService extends UserDetailsService {

	public void createUser(User u);
			//throws CannotCreateUserException;
//	public void updateUser(User u);
//	public User getUserById(Long userId);
//public Integer getRoleIdForUser(Integer userId);
//	public List<User> getFilteredUsers(String name);
//	public Map<Integer, String> getAllRoles();
//	public List<User> getAllUsers();
}
