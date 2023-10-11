package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.imageEntity;
import com.example.demo.repo.imageRepoInt;
@Service
public class imageService implements imageServiceInt {
 @Autowired
 private imageRepoInt iri;

@Override
public List<imageEntity> findById(int id) {
	// TODO Auto-generated method stub
	return iri.findAll();
}

@Override
public void postData(imageEntity ie) {
	iri.save(ie);
	
}

}
