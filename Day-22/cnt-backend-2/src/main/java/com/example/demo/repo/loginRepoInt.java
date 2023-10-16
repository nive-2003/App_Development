package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Entity.User;


@Repository
public interface loginRepoInt extends JpaRepository<User, Integer>{
	public List<User> findByUsernameAndPassword(String user,String pass);
	public List<User> findByEmailAndPassword(String email,String pass);

}
