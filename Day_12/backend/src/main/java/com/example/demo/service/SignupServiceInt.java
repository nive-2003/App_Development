package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.SignupEntity;

public interface SignupServiceInt {
	public List<SignupEntity> getdata();
	public void savedata(SignupEntity se);
	public void updatedata(SignupEntity se);
	public void deletedata(int id);
	public boolean checkUsername(String user);
	public boolean checkEmail(String email);

}
