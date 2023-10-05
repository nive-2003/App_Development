package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEntity;
import com.example.demo.repo.LoginRepoInt;

@Service
public class LoginService implements LoginServiceInt {
	
	@Autowired
	LoginRepoInt ri;

	@Override
	public List<LoginEntity> getData() {

		return ri.findAll();
	}

	@Override
	public List<LoginEntity> findByUsernameAndPassword(String user, String pass) {
		
		return ri.findByUsernameAndPassword(user, pass);
	}

	@Override
	public List<LoginEntity> findByEmailAndPassword(String email, String pass) {
	
		return ri.findByEmailAndPassword(email, pass);
	}

}
