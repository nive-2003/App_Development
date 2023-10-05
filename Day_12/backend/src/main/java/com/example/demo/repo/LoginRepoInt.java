package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LoginEntity;

@Repository
public interface LoginRepoInt extends JpaRepository<LoginEntity, Integer> {
	public List<LoginEntity> findByUsernameAndPassword(String user,String pass);
	public List<LoginEntity> findByEmailAndPassword(String email,String pass);

}
