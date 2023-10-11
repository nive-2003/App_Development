package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Entity.User;
import com.example.demo.repo.loginRepoInt;
@Service
public class loginService implements loginServiceInt {
	@Autowired
	private loginRepoInt lri;
	@Override
	public List<User> getData() {
		// TODO Auto-generated method stub
		return lri.findAll();
	}

	@Override
	public List<User> findByUsernameAndPassword(String user, String pass) {
		// TODO Auto-generated method stub
		return lri.findByUsernameAndPassword(user, pass);
	}

	@Override
	public List<User> findByEmailAndPassword(String user, String pass) {
		// TODO Auto-generated method stub
		return lri.findByEmailAndPassword(user, pass);
	}

}
