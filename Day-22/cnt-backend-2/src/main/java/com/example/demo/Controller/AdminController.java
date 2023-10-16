package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.example.demo.Entity.UpdateStatusDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.AuthenticationService;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.ImageuserService;
import com.example.demo.Service.UserService;
import com.example.demo.Service.imageService;
import com.example.demo.repo.UserRepoInt;
import com.example.demo.repo.imageuserRepoInt;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize("hasRole('ADMIN')")
@PreAuthorize("hasAuthority('ADMIN')")
@CrossOrigin
public class AdminController {

	@Autowired
	private UserService ss;
	@Autowired
	private EmailService es;
	@Autowired
	private UserRepoInt sri;
	@Autowired
	private imageService is;
	@Autowired
	private ImageuserService ius;

	@Autowired
	AuthenticationService serice;

	@GetMapping("/getdata")
	@PreAuthorize("hasAuthority('admin_Read')")
	public List<User> getdet() {
		System.out.println("hi");
		return ss.findByRole();
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
	@PreAuthorize("hasAuthority('admin:delete')")
	public String deletedata(@PathVariable int id) {
		ss.deleteData(id);
		return "id: " + id + "detail has been delete";
	}

//	@DeleteMapping("/deleteimagewithuser/{id}")
//	@PreAuthorize("hasAuthority('admin:delete')")
//	public String deleteimagewithuser(@PathVariable int id)
//	{
//		ius.deleteUserWithImage(id);
//		return "user removed";
//	}
	@PutMapping("/updateActiveStatus")
	@PreAuthorize("hasAuthority('admin:update')")
	public String updateActiveStatus(@RequestBody UpdateStatusDto dto) {
		User user = ss.findByUsername(dto.getUserName());
		System.out.println(user);
		if (dto.getIsactive() == 1) {
			user.setIsactive(true);
		} else if (dto.getIsactive() ==0)
			user.setIsactive(false);
		System.out.println(user);
		ss.updateData(user);
		return "active status updated";
	}
	@GetMapping("/getUserOfBan")
	@PreAuthorize("hasAuthority('admin_Read')")
	public List<User> getUserOfBan()
	{
		return ss.findByBannedUser();
		
	}
	
}
