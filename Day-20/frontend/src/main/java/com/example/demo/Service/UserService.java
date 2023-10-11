package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repo.UserRepoInt;

@Service
public class UserService implements UserServicInt {
	@Autowired
	private UserRepoInt sri;
	@Autowired
	private EmailService es;
//	@Autowired
//	private signupEntity se;
	@Override
	public List<User> getData() {
		// TODO Auto-generated method stub
		return sri.findAll();
	}

	@Override
	public void postData(User se) {
		// TODO Auto-generated method stub
		sri.save(se);

	}


	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		sri.deleteById(id);
	}

	@Override
	public boolean signupuser(String user) {
		// TODO Auto-generated method stub
		return sri.existsByUsername(user);
	}

	@Override
	public boolean signupemail(String email) {
		// TODO Auto-generated method stub
		return sri.existsByEmail(email);
	}

	@Override
	public List<User> getUserbyname(String username) {
		// TODO Auto-generated method stub
		return sri.findByusername(username);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return sri.findByEmail(email);
	}

	@Override
	public List<User> findByEmailAndCode(String email, String code) {
		// TODO Auto-generated method stub
		return sri.findByEmailAndCode(email, code);
	}

	public boolean signuppassword(String password) {
		// TODO Auto-generated method stub
		return sri.existsByPassword(password);
	}

	@Override
	public List<User> findByCode(String code) {
		// TODO Auto-generated method stub
		return sri.findByCode(code);
	}
	@Override
	public void updateData(User se) {
		// TODO Auto-generated method stub
		sri.save(se);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return sri.findByUsername(username);
	}

	@Override
	public List<User> findById(int id) {
		// TODO Auto-generated method stub
		return sri.findById(id);
	}
	

	
}

