package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.UserService;
import com.example.demo.repo.UserRepoInt;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

	@Autowired
	private UserService ss;
	@Autowired
	private EmailService es;
	@Autowired
	private UserRepoInt sri;
	
	@Autowired
	AuthenticationService serice;
	@GetMapping("/getdata")
	public List<User> getdet() {
		return ss.getData();
	}
	 @GetMapping("/summa")
	    @PreAuthorize("hasAuthority('admin_Read')")
	    public String get() {
		 
	        return "GET:: admin controller";
	    }

//	@PostMapping("/savedata")
//	public String savedata(@RequestBody User se) {
//		String username = se.getUsername();
//		String email = se.getEmail();
//		boolean checkEmail = ss.signupemail(email);
//		boolean checkUsername = ss.signupuser(username);
//		if (!checkEmail && !checkUsername) {
//			ss.postData(se);
//			return " signup successfull";
//		} else {
//			if (checkEmail)
//				return " Email already exist";
//			else
//				return " Username already exist";
//		}
//	}

	

	@DeleteMapping("/deletedata/{id}")
	public String deletedata(@PathVariable int id) {
		ss.deleteData(id);
		return "id: " + id + "detail has been delete";
	}

	@PostMapping(value = "/get-code/{email}")
	public ResponseEntity<String> sendCodeEmail(@PathVariable String email) {
		User se = sri.findByEmail(email);
		if (se != null) {
			try {
				String subject = "your code";
				es.sendEmail(email, se.getCode(), subject);
				return ResponseEntity.ok("Email sent successfully");
			} catch (MessagingException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}
	}

	@GetMapping("/checkcode/{email}/{code}")
	public String getbyemail(@PathVariable String email, @PathVariable String code) {
		List<User> obj = new ArrayList<>();
		obj = ss.findByEmailAndCode(email, code);
		if (obj.isEmpty()) {
			return "verification failed";
		} else {
			return "verified";
		}
	}

	@GetMapping("/getdetail/{username}")
	public List<User> getDetail(@PathVariable String username) {
		return ss.getUserbyname(username);
	}

	@GetMapping("/userimage/{id}")
	public List<User> userImage(int id) {
		return ss.findById(id);
	}
	
}
