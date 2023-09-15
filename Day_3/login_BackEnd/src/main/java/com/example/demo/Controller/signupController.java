package com.example.demo.Controller;

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

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.signupEntity;
import com.example.demo.Service.signupService;

@RestController
@CrossOrigin("*")
public class signupController {
	@Autowired
	private signupService ss;
	@GetMapping("/getdata")
	public List<signupEntity> getdet()
	{
		return ss.getData();
	}
	@PostMapping("/savedata")
	public String savedata(@RequestBody signupEntity se)
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
	@PutMapping("/updatedata/{id}")
	public String updatedata(@PathVariable int id ,@RequestBody signupEntity se)
	{
		boolean checkEmail = ss.signupemail(se.getEmail());
		boolean checkUsername = ss.signupuser(se.getUsername());
		if(!checkEmail && !checkUsername)
		{
			ss.updateData(se);
			return " update successfull";
		}
		else if(checkEmail && checkUsername)
		{
			return "Email & Username already exist";
		}
		else
		{
			if(checkEmail)
				return " Email already exist";
			else
				return " Username already exist";
		}
		
	}
	@DeleteMapping("/deletedata/{id}")
	public String deletedata(@PathVariable int id)
	{
		ss.deleteData(id);
		return "id: "+id+ "detail has been delete";
	}
	@GetMapping(value = "/getbyname/{username}")
	private ResponseEntity<Object> getuserbyname(@PathVariable String username) {
		List<signupEntity> estateModel = ss.getUserbyname(username);
		return new ResponseEntity<>(estateModel, HttpStatus.OK);
	}
	

}
