package com.auction.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.model.AngularJSONResponse;
import com.auction.model.User;
import com.auction.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import payload.request.LoginRequest;
import payload.response.JwtResponse;
import security.jwt.JwtUtils;
import security.services.UserDetailsImpl;

@RestController

@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;

	@RequestMapping("/createUser")
	public AngularJSONResponse createUser(@RequestBody User user) {
		//try {
			userService.createUser(user);

			return new AngularJSONResponse("User " + user.getUserName() + " created!");

//		} catch (CannotCreateUserException e) {
//			AjaxStatus status = new AjaxStatus(Constants.HTTP_STATUS_BUSINESS_ERROR, 123, "Error while creating user!");
//			return new AngularJSONResponse(status, null);
//		}

	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}


//	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
//	@RequestMapping("/getAllUsers")
//	public AngularJSONResponse getAllUsers() {
//
//		List<User> users = userService.getAllUsers();
//		return new AngularJSONResponse(users);
//	}
//
//	@RequestMapping("/updateUser")
//	public AngularJSONResponse updateUser(User user) {
//
//		userService.updateUser(user);
//		return new AngularJSONResponse("User " + user.getUserName() + " updated!");
//
//	}
//
//
//	@PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
//	@RequestMapping("/getFilteredUsers")
//	public AngularJSONResponse getFilteredUsers(String name) {
//		return new AngularJSONResponse(userService.getFilteredUsers(name));
//
//	}


}