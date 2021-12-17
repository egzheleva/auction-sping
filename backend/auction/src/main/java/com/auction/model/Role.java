package com.auction.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public Role() {
		
	}

	public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getAuthority() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Role){
			return ( (Role) obj ).getName().equals(this.getName());
		}
		return false;
	}


}
