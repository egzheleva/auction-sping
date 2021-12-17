package com.auction.model;

import java.util.HashSet;
import java.util.Set;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
	private String userName;
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private Date registeredOn;
	private String password;
	private Set roles = new HashSet<Role>();
	private Integer roleId;
	private String phoneNumber;
	
	public User() {}
	

	public User(String userName, String firstName, String middleName, String lastName, String email,
			Date registeredOn, String password, Set<Role> roles, Integer roleId, String phoneNumber) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.registeredOn = registeredOn;
		this.password = password;
		this.roles = roles;
		this.roleId = roleId;
		this.phoneNumber = phoneNumber;
	}
	
	public User(User user) {
		super();
		this.userName = user.getUserName();
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.middleName = user.getMiddleName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.registeredOn = user.getRegisteredOn();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.roleId = user.getRoleId();
	}
	
	public boolean hasRole(String roleName){
		return roles.contains(roleName);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisteredOn() {
		return registeredOn;
	}
	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}