package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.imageEntity;

public interface imageServiceInt {
	public void postData(imageEntity ie);
	public List<imageEntity> getAllImage();

}
