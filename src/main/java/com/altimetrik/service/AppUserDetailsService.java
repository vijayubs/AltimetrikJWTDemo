package com.altimetrik.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("altimetrik".equals(username)) {			
			return new User("altimetrik", "$2a$04$qecDEOFdGwn0UcvxPAiPYOXnLazxuYmIXuWzZdQOEGQleAg35wsBO",
				new ArrayList<>());
			
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}