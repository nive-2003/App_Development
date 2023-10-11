package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.imageEntity;

public interface imageRepoInt extends JpaRepository<imageEntity, Integer> {
	public List<imageEntity> findById(int id);
}
