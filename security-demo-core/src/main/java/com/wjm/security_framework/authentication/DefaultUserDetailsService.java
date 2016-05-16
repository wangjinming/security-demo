package com.wjm.security_framework.authentication;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.wjm.security_framework.entities.User;
import com.wjm.security_framework.service.AuthenticationService;

@Component
public class DefaultUserDetailsService implements UserDetailsService {

	
	@Autowired
	private AuthenticationService authService;
	

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Collection<GrantedAuthority> auths;
		
		User user = authService.getUserByName(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username Not Found");
		} else {
			UserDetailsImpl userDetails = new UserDetailsImpl(user);
			auths = authService.loadUserAuthorities(username);	
			userDetails.setAuthorities(auths);
			
			return userDetails;
		}
	}

}

