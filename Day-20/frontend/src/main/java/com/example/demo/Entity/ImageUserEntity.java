package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="UserImageDetails")
public class ImageUserEntity {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="username")
	private String username;

    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    @OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true)
	private List<imageEntity> images;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<imageEntity> getImages() {
		return images;
	}

	public void setImages(List<imageEntity> images) {
		this.images = images;
	}

	public ImageUserEntity(int id, String username, User user, List<imageEntity> images) {
		super();
		this.id = id;
		this.username = username;
		this.user = user;
		this.images = images;
	}

	public ImageUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
    
	
    

}
