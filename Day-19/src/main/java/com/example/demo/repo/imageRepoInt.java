package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.imageEntity;
import com.example.demo.Entity.User;

@Repository
public interface imageRepoInt extends JpaRepository<imageEntity, Integer> {

}
