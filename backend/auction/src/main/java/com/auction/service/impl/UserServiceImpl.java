package com.auction.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auction.config.Constants;
import com.auction.dao.UserDao;
import com.auction.model.Role;
import com.auction.model.User;
import com.auction.model.UserRepositoryUserDetails;
import com.auction.service.UserService;

import utils.RolesHelper;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}

	@Override
	public void createUser(User newUser) {
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Long logedUserId = RolesHelper.getUserId(auth);
//		String randomToken = UUID.randomUUID().toString();
//		newUser.setVerifyingToken(randomToken);
//		UserRepositoryUserDetails creator = null;
//		if (logedUserId != null) {
//
//			creator = (UserRepositoryUserDetails) auth.getPrincipal();
//			if (creator.hasRole(Constants.ROLE_ADMIN)) {
//				Role role = new Role(Constants.ROLE_MOD_ID, "moderator");
//				HashSet<Role> userRoles = new HashSet<Role>();
//				userRoles.add(role);
//				newUser.setRoles(userRoles);
//			} else if (creator.hasRole(Constants.ROLE_MOD)) {
//				Role role = new Role(Constants.ROLE_MOD_ID, "moderator");
//				HashSet<Role> userRoles = new HashSet<Role>();
//				userRoles.add(role);
//				newUser.setRoles(userRoles);
//			}
//		}
//		userDao.createUser(newUser, creator, 0);
		
		
		
		
		
		
		
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//		return ResponseEntity
//				.badRequest()
//				.body(new MessageResponse("Error: Username is already taken!"));
//	}
//
//	if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//		return ResponseEntity
//				.badRequest()
//				.body(new MessageResponse("Error: Email is already in use!"));
//	}

	// Create new user's account
//	User user = new User(newUser.getUserName(), 
//						 newUser.getEmail(),
//						 newUser.getPassword());

	//Set<String> strRoles = signUpRequest.getRole();
	//Set<Role> roles = new HashSet<>();

//	if (strRoles == null) {
//		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//		roles.add(userRole);
//	} else {
//		strRoles.forEach(role -> {
//			switch (role) {
//			case "admin":
//				Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(adminRole);
//
//				break;
//			case "mod":
//				Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(modRole);
//
//				break;
//			default:
//				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//				roles.add(userRole);
//			}
//		});
//	}

	//String role = Constants.ROLE_REGULAR;
	newUser.setRoleId(1);
	//user.setRoles(roles);
	userDao.createUser(newUser);

	//return ResponseEntity.ok(new MessageResponse("User registered successfully!"));


	}

}
