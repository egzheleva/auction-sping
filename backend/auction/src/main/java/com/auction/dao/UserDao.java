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
//	//public void sendEmail(String firstName, String lastName, String email, String token);
//	public User getUserById(Long userId);
//	public User getUserByRegistrationToken(String token);
//	public void createActiveRegistrationForUser(Long userId, String password);
//	public void forgottenPasswordEmail(String email);
//	public User getUserByForgottenPasswordToken(String token);
//	//public Integer getRoleIdForUser(Integer userId);
//	public User getUserByEmail(String email, boolean isNewUser) throws UsernameNotFoundException;
//	public List<User> getFilteredUsers(String name, UserRepositoryUserDetails user);
//	public Map<Integer, String> getAllRoles();
//	public List<User> getAllUsers();
//	public List<User> getParticipantsForCampaign(Long campaignId);
}
