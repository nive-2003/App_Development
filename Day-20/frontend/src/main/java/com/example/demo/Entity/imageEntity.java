package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ImageDetails")
public class imageEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imageid")
	private int imageid;
	@Column(name="imagecaption")
	private String imagecaption;
	@Column(name="imageurl")
	private String imageurl;
	@Column(name="category")
	private String category;
	@Column(name="likes")
	private int likes;
	@Column(name="saved")
	private boolean saved;
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName="id")
	private User id;
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getImagecaption() {
		return imagecaption;
	}
	public void setImagecaption(String imagecaption) {
		this.imagecaption = imagecaption;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public User getId() {
		return id;
	}
	public void setId(User id) {
		this.id = id;
	}
	public imageEntity(int imageid, String imagecaption, String imageurl, String category, int likes, boolean saved,
			User id) {
		super();
		this.imageid = imageid;
		this.imagecaption = imagecaption;
		this.imageurl = imageurl;
		this.category = category;
		this.likes = likes;
		this.saved = saved;
		this.id = id;
	}
	public imageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
	
	
	
	

}
