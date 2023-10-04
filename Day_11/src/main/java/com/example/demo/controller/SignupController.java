package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SignupEntity;
import com.example.demo.service.SignupService;

@RestController
public class SignupController {
	@Autowired
	private SignupService ss;
	
	@GetMapping("/getdata")
	public List<SignupEntity> getdetails(){
		return ss.getdata();
	}
	
	@PutMapping("/updatedata")
	public void updateLibraryData(@RequestBody SignupEntity se,@RequestParam int id) {
		se.setId(id);
		ss.updatedata(se);
	}
	
	@DeleteMapping("/deletedata")
	public void deleteDetails(@RequestParam int id) {
		ss.deletedata(id);
	}
	
	@PostMapping("/savedata")
	public String updatedetails(@RequestBody SignupEntity se) {
		boolean isUserExist = ss.checkUsername(se.getUsername());
		boolean isEmailExist = ss.checkEmail(se.getEmail());
		
		if(isUserExist) {
			return "Username already exists";
		}
		else if(isEmailExist)
			return "Email already exists";
	else {
		ss.updatedata(se);
		return "Signuup success";
	}
	}
}

