package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.signupEntity;

public interface signupServiceInt {
	public List<signupEntity> getData();
	public void postData(signupEntity se);
	public void updateData(signupEntity se);
	public void deleteData(int id);
	public boolean signupuser(String user);
	public boolean signupemail(String email);
	public  List<signupEntity> getUserbyname(String username);

}
