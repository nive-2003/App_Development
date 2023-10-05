package com.example.content.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.content.model.User;

public interface AuthRepository extends JpaRepository<User, Integer>{

    Optional<User> findByEmail(String username);
    

}
