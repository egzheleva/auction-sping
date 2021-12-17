package com.auction.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.auction.model.User;

public interface UserService extends UserDetailsService {

	public void createUser(User u);
			//throws CannotCreateUserException;
//	public void updateUser(User u);
//	public void sendEmail(String firstName, String lastName, String email, String token);
//	public User getUserById(Long userId);
//	public User getUserByRegistrationToken(String token) throws UsedRegistrationTokenException;
//	public void createActiveRegistrationForUser(String password, String token);
//	public void forgottenPasswordEmail(String email);
//	public User getUserByForgottenPasswordToken(String token);
	//public Integer getRoleIdForUser(Integer userId);
//	public User getUserByEmail(String email, boolean isNewUser) throws UsernameNotFoundException;
//	public List<User> getFilteredUsers(String name);
//	public Map<Integer, String> getAllRoles();
//	public List<User> getAllUsers();
//	public List<User> getParticipantsForCampaign(Long campaignId);
}
