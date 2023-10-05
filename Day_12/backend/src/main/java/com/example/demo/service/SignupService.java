package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SignupEntity;
import com.example.demo.repo.SignupRepoInt;

@Service
public class SignupService implements SignupServiceInt {

	@Autowired
	SignupRepoInt sr;
	@Override
	public List<SignupEntity> getdata() {
		
		return sr.findAll();
	}

	@Override
	public void savedata(SignupEntity se) {
	     sr.save(se);
		
	}

	@Override
	public void updatedata(SignupEntity se) {
		sr.save(se);
	}

	@Override
	public void deletedata(int id) {
		sr.deleteById(id);
		
	}

	@Override
	public boolean checkUsername(String user) {
		
		return sr.existsByUsername(user);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return sr.existsByEmail(email);
	}

	

}
