package com.auction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.auction.config.Constants;
import com.auction.dao.UserDao;
import com.auction.model.Role;
import com.auction.model.User;
import com.auction.model.UserRepositoryUserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTmpl;
	
	@Autowired
	PasswordEncoder encoder;

	static final Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Loading user with username " + username);

		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT u.userId, u.password, u.username, u.email, u.firstName, u.surname,u.lastName, u.registered_on, u.role_id ");
		sql.append(" FROM user u");
		sql.append(" WHERE u.username = :username ");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);

		User user = jdbcTmpl.query(sql.toString(), params, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()) {
					user.setId(rs.getLong("userId"));
					user.setPassword(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setUserName(rs.getString("username"));
					user.setFirstName(rs.getString("firstName"));
					user.setMiddleName(rs.getString("surname"));
					user.setLastName(rs.getString("lastName"));
					user.setRoleId(rs.getInt("role_id"));
					user.setRegisteredOn(rs.getDate("registered_on"));
					user.setRoles(setUserRoles(user.getRoleId()));
				}
				return user;
			}
		});

		return new UserRepositoryUserDetails(user);
	}

	private Set<Role> setUserRoles(Integer roleId) {
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setId(roleId);
		role.setName("ADMIN"); // TODO fix this
		roles.add(role);
		return roles;
	}
	@Override
	public void createUser(User user) {

		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT into user (firstName, surname, lastName, email, username, registered_on, phone, role_id, password) ");
		sql.append(" values (:firstName, :surname, :lastName, :email, :username, current_timestamp, :phone, :role_id, :password) ");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("firstName", user.getFirstName());  
		paramMap.put("surname", user.getMiddleName());  
		paramMap.put("lastName", user.getLastName());
		paramMap.put("email", user.getEmail());
		paramMap.put("username", user.getUserName());  
		paramMap.put("phone", user.getPhoneNumber());
		paramMap.put("role_id", user.getRoleId());
		paramMap.put("password", encoder.encode(user.getPassword().toString()));

		jdbcTmpl.update(sql.toString(), paramMap);
	}

	
}
