package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.imageEntity;
import com.example.demo.Service.imageService;

@RestController
@CrossOrigin("*")
public class imageController {
	@Autowired
	private imageService is;
	@GetMapping("/image/{id}")
	public List<imageEntity>getImageById(@PathVariable int id)
	{
		return is.findById(id);
	}
	@PostMapping("/image/savedata")
	public String savedata(@RequestBody imageEntity ie)
	{
		
		is.postData(ie);
		return "image added";
	}
	

}
