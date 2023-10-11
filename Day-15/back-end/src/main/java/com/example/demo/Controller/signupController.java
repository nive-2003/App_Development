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
import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.signupService;
import com.example.demo.repo.signupRepoInt;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin("*")
public class signupController {
	@Autowired
	private signupService ss;
	@Autowired
	private EmailService es;
	@Autowired
	private signupRepoInt sri;
	@GetMapping("/getdata")
	public List<User> getdet()
	{
		return ss.getData();
	}
	@PostMapping("/savedata")
	public String savedata(@RequestBody User se)
	{
		String username = se.getUsername();
		String email = se.getEmail();
		boolean checkEmail = ss.signupemail(email);
		boolean checkUsername = ss.signupuser(username);
		if(!checkEmail && !checkUsername)
		{
			ss.postData(se);
			return " signup successfull";
		}
		else
		{
			if(checkEmail)
				return " Email already exist";
			else
				return " Username already exist";
		}
	}
//	@PutMapping("/updatePassword/{email}/{password}/{code}")
//		public String UpdatePassword(@PathVariable String email,@PathVariable String password,@PathVariable String code)
//		{
//		signupEntity user = ss.findByEmail(email);
//		if(user!=null)
//		{
//			user.setPassword(password);
//			user.setCode(code);
//			ss.updateData(user);
//			return "PASSWORD CHANGED";
//		}
//		else
//			return "Email not Found";
//		}
	@DeleteMapping("/deletedata/{id}")
	public String deletedata(@PathVariable int id)
	{
		ss.deleteData(id);
		return "id: "+id+ "detail has been delete";
	}
//	@PostMapping(value="/get-code/{email}")
//	public ResponseEntity<String>sendCodeEmail(@PathVariable String email){
//		signupEntity se = sri.findByEmail(email);
//        if (se != null) {
//            try {
//            	String subject = "your code";
//                es.sendEmail(email, se.getCode(),subject);
//                return ResponseEntity.ok("Email sent successfully");
//            } catch (MessagingException e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
//	}
	@GetMapping("/checkcode/{email}/{code}")
	public String getbyemail(@PathVariable String email,@PathVariable String code)
	{
		List<User>obj = new ArrayList<>();
		obj=ss.findByEmailAndCode(email, code);
		if(obj.isEmpty())
		{
			return "verification failed";
		}
		else
		{
			return "verified";	
		}
	}
	@GetMapping("/getdetail/{username}")
	public List<User> getDetail(@PathVariable String username)
	{
		return ss.getUserbyname(username);
	}

	//SECURITY
	
//	private AuthenticationService service;
//	@PostMapping("/register")
//	public ResponseEntity<AuthenticationResponse> register(
//			@RequestBody RegisterRequest request 
//			){
//		return ResponseEntity.ok(service.register(request));
//	}
//	@PostMapping("/authenticate")
//	public ResponseEntity<AuthenticationResponse> register(
//			@RequestBody AuthenticationRequest request 
//			){
//		return ResponseEntity.ok(service.authenticate(request));
//	}
	
	
}
