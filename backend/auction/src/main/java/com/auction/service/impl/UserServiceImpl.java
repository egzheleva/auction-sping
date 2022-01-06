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
		
	newUser.setRoleId(1); // regular user
	userDao.createUser(newUser);
	}

}
