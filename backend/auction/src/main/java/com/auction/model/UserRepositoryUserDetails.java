package com.auction.model;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserRepositoryUserDetails extends User implements UserDetails  {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public UserRepositoryUserDetails(User user) {
			super(user);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return (Collection<? extends GrantedAuthority>) getRoles();
		}

		@Override
		public String getUsername() {
			return getUserName();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
		
		public boolean hasRole(String roleName){
			Iterator<Role> i = this.getRoles().iterator();
			while(i.hasNext()){
				Role currRole = i.next();
				if( currRole.getName().equals(roleName) ){
					return true;
				}
			}
			return false;
		}

	}
