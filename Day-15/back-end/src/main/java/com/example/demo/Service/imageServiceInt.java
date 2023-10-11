package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.imageEntity;

public interface imageServiceInt {
	public List<imageEntity> findById(int id);
	public void postData(imageEntity ie);

}
