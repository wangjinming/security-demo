package com.wjm.security_framework.authentication;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wjm.security_framework.entities.User;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = -4832684749880934352L;
	
	private User user;
	
	Collection<GrantedAuthority> auths = new LinkedList<GrantedAuthority>();
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auths;
	}
	
	public void setAuthorities(Collection<GrantedAuthority> auths) {
		this.auths = auths;
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {	
		return user.getName();
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
		return user.isEnabled();
	}

}
