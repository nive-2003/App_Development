package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.UserService;

import lombok.RequiredArgsConstructor;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;
	@Autowired
	private UserService ss;

	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello");
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		String username = request.getUsername();
		String email = request.getEmail();
		boolean checkEmail = ss.signupemail(email);
		boolean checkUsername = ss.signupuser(username);
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();
		if (!checkEmail && !checkUsername) {
//			ss.postData(ss);
//			service.register(request);
			AuthenticationResponse register = service.register(request);
			
			register.setMessage(" signup successfull");

			return ResponseEntity.ok(register);
		} 
		
		else {
			if (checkEmail)
				authenticationResponse.setMessage( " Email already exist");
			else
				authenticationResponse.setMessage(" Username already exist");
//			authenticationResponse.setMessage("notttt");
			return ResponseEntity.ok(authenticationResponse);
		}
		
//		return new ResponseEntity<>()
		
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//		System.out.println("hi");
		return ResponseEntity.ok(service.authenticate(request));
	}
	
	@PutMapping("/changepassword/{code}/{password}/{email}")
	public String changepass(@PathVariable String code,@PathVariable String email,@PathVariable String password)
	{
		service.updatePassword(code,email, password);
		return "password changed";
	}

}
