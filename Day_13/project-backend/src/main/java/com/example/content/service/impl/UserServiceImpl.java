package com.example.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.content.model.User;
import com.example.content.repository.AuthRepository;
import com.example.content.repository.UserRepository;
import com.example.content.service.UserService;
import com.example.content.util.JwtUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	@Override
	public List<User> getData() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public void postData(User se) {
		// TODO Auto-generated method stub
		repo.save(se);

	}

	@Override
	public void deleteData(int uid) {
		// TODO Auto-generated method stub
		repo.deleteById(uid);
	}

	@Override
	public boolean signupuser(String user) {
		// TODO Auto-generated method stub
		return repo.existsByUsername(user);
	}

	@Override
	public boolean signupemail(String email) {
		// TODO Auto-generated method stub
		return repo.existsByEmail(email);
	}

	@Override
	public List<User> getUserbyname(String username) {
		// TODO Auto-generated method stub
		return repo.findByusernameContainingIgnoreCase(username);
	}

	@Override
	public List<User> findByEmailAndCode(String email, String code) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndCode(email, code);
	}

	public boolean signuppassword(String password) {
		// TODO Auto-generated method stub
		return repo.existsByPassword(password);
	}

	@Override
	public List<User> findByCode(String code) {
		// TODO Auto-generated method stub
		return repo.findByCode(code);
	}
	@Override
	public void updateData(User se) {
		// TODO Auto-generated method stub
		repo.save(se);
	}
}
