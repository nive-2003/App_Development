package com.example.demo.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.err.println(username);
		 User user = userRepository.findByUsername(username).get();
           System.err.println(user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.getAuthorities());
	}
}
