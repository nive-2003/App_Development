package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.config.JwtService;
import com.example.demo.Controller.AuthenticationRequest;
import com.example.demo.Controller.AuthenticationResponse;
import com.example.demo.Controller.RegisterRequest;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.repo.signupRepoInt;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
	private signupRepoInt repo;
	
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private  AuthenticationManager authenticationManager;
    
//	public AuthenticationResponse register(RegisterRequest request) {
//		List<signupEntity> user = User.builder()
//				.username(request.getUsername())
//				.email(request.getEmail())
//				.password(passwordEncoder.encode(request.getPassword()))
//				.role(Role.USER)
//				.build();
//		repo.save(user);
//		var jwtToken = jwtService.generateToken(user);
//				
//		return AuthenticationResponse.builder()
//				.token(jwtToken)
//				.build();
//	}
//	public AuthenticationResponse authenticate(RegisterRequest request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
    public AuthenticationResponse userRegistration(RegisterRequest request) {
        Optional<User> isUserExists = repo.findByEmail(request.getEmail());
 
          User user = new  User();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.isEnabled();
            user.setRole(Role.USER);
//                    .password(passwordEncoder.encode(request.getPassword()))
//                    .isEnabled(true)
//                    .role(Role.USER)
//                    .build();
            repo.save(user);
            var token = jwtService.generateToken(user);
            return AuthenticationResponse.builder().build();
        
            
    }
    public AuthenticationResponse userAuthentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repo.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
	
}
