package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.UserService;
import com.example.demo.repo.UserRepoInt;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService ss;
	@Autowired
	private EmailService es;
	@Autowired
	private UserRepoInt sri;

	
	@PutMapping("/updatePassword/{email}/{password}/{code}")
	public String UpdatePassword(@PathVariable String email, @PathVariable String password, @PathVariable String code) {
		User user = ss.findByEmail(email);
		if (user != null) {
			user.setPassword(password);
			user.setCode(code);
			ss.updateData(user);
			return "PASSWORD CHANGED";
		} else
			return "Email not Found";
	}

	

	

	

	

}
