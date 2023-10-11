package com.example.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.User;

public interface UserServicInt {
	public List<User> getData();
	public void postData(User se);
	public void updateData(User se);
	public void deleteData(int id);
	public boolean signupuser(String user);
	public boolean signuppassword(String password);
	public  List<User> getUserbyname(String username);
	public boolean signupemail(String email);
	@Query("SELECT s FROM signupEntity s WHERE s.email = :email")
	public User findByEmail(@Param("email") String email);
	public List<User> findByCode(String code);
	public User findByUsername(String username);
	public List<User> findByEmailAndCode(String email,String code);
	public List<User>findById(int id);
}
