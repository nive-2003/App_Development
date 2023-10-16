package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Controller.AuthenticationRequest;
import com.example.demo.Controller.AuthenticationResponse;
import com.example.demo.Controller.RegisterRequest;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.config.JwtService;
import com.example.demo.repo.UserRepoInt;
import com.example.demo.repo.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepository userRepository;
	private final UserRepoInt uri;
//	@Bean
//	public BCryptPasswordEncoder passwordencoder()
//	{
//	    return new BCryptPasswordEncoder();
//	}
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	@Autowired
	 private  PasswordEncoder encoder;
	
	
	public AuthenticationResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
//		 StandardPasswordEncoder encoder = new StandardPasswordEncoder("secret");
//		 String result = encoder.encode(request.getPassword());
		
		var user = User.builder()
				  .username(request.getUsername())
				  .email(request.getEmail())
				  .password(encoder.encode(request.getPassword()))
				  .role(request.getRole())
				  .code(request.getCode())
				  .profileurl(request.getProfileurl())
				  .isactive(true)
				  .build();
		userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken).build();
		
		
	}
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
//		System.err.println("inside authen service");
		
		  authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		System.err.println("pass");
		var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		System.err.println(user);
		
//		AuthenticationResponse.builder().role(user.getRole());
		var jwtToken = jwtService.generateToken(user);
		System.err.println(jwtToken);
		return AuthenticationResponse.builder().role(user.getRole())
				.token(jwtToken).build();
	}
	public void updatePassword(String code , String email,String pass) {
        User user = uri.findByEmail(email);

        // Encode the new password using the password encoder
        String encodedPassword = encoder.encode(pass);

        // Update the user's password
        user.setPassword(encodedPassword);

        // Save the updated user
        userRepository.save(user);
    }
}
