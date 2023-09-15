package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.signupEntity;
import com.example.demo.Service.loginService;


@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class loginController {
	@Autowired
	private loginService ls;
	@GetMapping("/getdata")
	public List<signupEntity>getdata()
	{
		return ls.getData();
	}
	@GetMapping("/login/{username}/{password}")
	public String getbyusername(@PathVariable String username,@PathVariable String password)
	{
		List<signupEntity>obj = new ArrayList<>();
		obj=ls.findByUsernameAndPassword(username, password);
		if(obj.isEmpty())
		{
			return "login failed";
		}
		else
		{
			return "login sucessfully";
		}
	}

}
