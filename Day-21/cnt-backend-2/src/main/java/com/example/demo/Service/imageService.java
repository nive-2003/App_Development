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

@Override
public void updateLikeData(imageEntity ie) {
	// TODO Auto-generated method stub
	iri.save(ie);
	
	
}

@Override
public imageEntity findByImageId(int id) {
	// TODO Auto-generated method stub
	return iri.findByImageid(id);
}

@Override
public List<imageEntity> findByCategory(String category) {
	// TODO Auto-generated method stub
	return iri.findByCategory(category);
}



}
