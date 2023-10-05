package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LoginEntity;

public interface LoginServiceInt {
	public List<LoginEntity> getData();
	public List<LoginEntity> findByUsernameAndPassword(String user,String pass);
	public List<LoginEntity> findByEmailAndPassword(String email,String pass);
	

}
