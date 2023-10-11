package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.ImageUserEntity;

@Repository
public interface imageuserRepoInt extends JpaRepository<ImageUserEntity, Integer> {
	@Query("select u from ImageUserEntity u where u.username=?1")
	public List<ImageUserEntity> getByUsername(String username);

}
