package com.auction.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.auction.model.User;
import com.auction.model.UserRepositoryUserDetails;

public interface UserDao {
	public UserDetails loadUserByUsername(String username);
			//throws UsernameNotFoundException;
	public void createUser(User u);
			//throws CannotCreateUserException;
//	public void updateUser(User u);
//	public User getUserById(Long userId);
//	public List<User> getFilteredUsers(String name, UserRepositoryUserDetails user);
//	public Map<Integer, String> getAllRoles();
//	public List<User> getAllUsers();
}
