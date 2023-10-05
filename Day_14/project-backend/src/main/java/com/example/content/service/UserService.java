package com.example.content.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.content.model.User;


public interface UserService {
	public List<User> getData();
	public void postData(User se);
	public void updateData(User se);
	public void deleteData(int uid);
	public boolean signupuser(String user);
	public boolean signuppassword(String password);
	public  List<User> getUserbyname(String username);
	public boolean signupemail(String email);
	
	public List<User> findByCode(String code);
	
	public List<User> findByEmailAndCode(String email,String code);
}
