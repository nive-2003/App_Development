package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.ImageUserEntity;
import com.example.demo.Entity.imageEntity;
import com.example.demo.repo.imageRepoInt;
import com.example.demo.repo.imageuserRepoInt;
@Service
public class imageService implements imageServiceInt {
 @Autowired
 private imageRepoInt iri;
 @Autowired
 private imageuserRepoInt iuri;


@Override
public void postData(imageEntity ie) {
	iri.save(ie);
	
}

@Override
public List<imageEntity> getAllImage() {
	// TODO Auto-generated method stub
	return iri.findAll();
}


public List<imageEntity> getAllImages(String username) {
	
	ImageUserEntity user = iuri.getByUsername(username).get(0);
	
	return user.getImages();
}



}
