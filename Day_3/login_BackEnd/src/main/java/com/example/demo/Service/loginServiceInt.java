package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.signupEntity;

public interface loginServiceInt {
	public List<signupEntity> getData();
	public List<signupEntity> findByUsernameAndPassword(String user,String pass);
	public List<signupEntity> findByEmailAndPassword(String user,String pass);

}
