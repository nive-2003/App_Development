package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Entity.signupEntity;


@Repository
public interface loginRepoInt extends JpaRepository<signupEntity, Integer>{
	public List<signupEntity> findByUsernameAndPassword(String user,String pass);
	public List<signupEntity> findByEmailAndPassword(String email,String pass);

}
