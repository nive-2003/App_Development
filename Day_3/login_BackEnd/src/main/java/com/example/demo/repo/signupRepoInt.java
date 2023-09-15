package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.signupEntity;

public interface signupRepoInt extends JpaRepository<signupEntity, Integer> {
	public boolean existsByUsername(String user);
	public boolean existsByEmail(String email);
	public signupEntity findByUsername(String username);
	public List<signupEntity> findByusernameContainingIgnoreCase(String username);

}
