package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface UserRepoInt extends JpaRepository<User, Integer> {
	public boolean existsByUsername(String user);
	public boolean existsByEmail(String email);
	public boolean existsByPassword(String password);
	public User findByUsername(String username);
	public List<User> findByusernameContainingIgnoreCase(String username);
	public List<User> findByusername(String username);
	public User findByEmail(String email);
	public List<User> findByCode(String code);
	public List<User> findByEmailAndCode(String email,String code);
	public List<User> findById(int id);
//	public void isActiveUser(int id);

}
