package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.Entity.ImageUserEntity;
import com.example.demo.Entity.imageEntity;
import com.example.demo.repo.imageuserRepoInt;

@Service
public class ImageuserService {
	@Autowired
	imageuserRepoInt iuri;
	
	public ImageUserEntity postUserImage(ImageUserEntity iue)
	{
		List<ImageUserEntity> user = iuri.getByUsername(iue.getUser().getUsername());
		if(user.size()!=0)
		{
			ImageUserEntity oldUser = iuri.findById(user.get(0).getId()).get();
			oldUser.getImages().add(iue.getImages().get(0));
			return iuri.save(oldUser);
		}
		else
		{
			return iuri.save(iue);
		}
	}
	
	public List<ImageUserEntity> getAllObj() {
		// TODO Auto-generated method stub
		return iuri.findAll();
	}
	public List<ImageUserEntity> getByUsername(String username)
	{
		return iuri.getByUsername(username);
	}
	
}
