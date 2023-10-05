package com.example.content.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.content.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    public boolean existsByUsername(String username);
//    public void deleteByUId(int uid);
	public boolean existsByEmail(String email);
	public boolean existsByPassword(String password);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public List<User> findByusernameContainingIgnoreCase(String username);
	public List<User> findByCode(String code);
	public List<User> findByEmailAndCode(String email,String code);
    

}