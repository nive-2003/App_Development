package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.example.demo.Entity.ImageUserEntity;
import com.example.demo.Entity.imageEntity;
import com.example.demo.Service.ImageuserService;
import com.example.demo.repo.imageuserRepoInt;

@RestController
@CrossOrigin("*")
@RequestMapping("/image_user")
public class ImageUserController {
	@Autowired
	ImageuserService ius;
	@Autowired
	imageuserRepoInt iuri;
	@Operation(summary = "Add new image of a user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "image posted  successfully"),
			@ApiResponse(responseCode = "400", description = "Could not post image")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/postimagesbyuser")
	public ResponseEntity<ImageUserEntity>postUserImages(@RequestBody ImageUserEntity iue)
	{
		return ResponseEntity.ok(ius.postUserImage(iue));
	}
	@Operation(summary = "Get image of a user")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "image got successfully"),
			@ApiResponse(responseCode = "400", description = "Could not image image")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/getuserandiamge")
	public List<ImageUserEntity>getUserAndImage()
	{
		return ius.getAllObj();
	}

//
//	@GetMapping("/byusername/{username}")
//	public List<ImageUserEntity>getuserandimageByName(@PathVariable String username)
//	{
//		return ius.getByUsername(username);
//	}
	
	
	

	
	 
	

}
