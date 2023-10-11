package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;

public interface loginServiceInt {
	public List<User> getData();
	public List<User> findByUsernameAndPassword(String user,String pass);
	public List<User> findByEmailAndPassword(String user,String pass);

}
