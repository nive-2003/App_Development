package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SignupEntity;

@Repository
public interface SignupRepoInt extends JpaRepository<SignupEntity, Integer> {
	public boolean existsByUsername(String user);
	public boolean existsByEmail(String email);

}
