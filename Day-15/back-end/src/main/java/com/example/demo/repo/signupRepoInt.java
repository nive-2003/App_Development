package com.example.demo.repo;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface signupRepoInt extends JpaRepository<User, Integer> {
	public boolean existsByUsername(String user);
	public boolean existsByEmail(String email);
	public boolean existsByPassword(String password);
	public User findByUsername(String username);
	public List<User> findByusernameContainingIgnoreCase(String username);
	public List<User> findByCode(String code);
	public Optional<User> findByEmail(String email);
	
	public List<User> findByEmailAndCode(String email,String code);

//	public void save(List<signupEntity> user);
	
	
	
//	Security
//	Optional<signupEntity> findByEmail1(String email);

	

}
