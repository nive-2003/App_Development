package com.example.demo.Controller;

import com.example.demo.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String username;
	private String email;
	private String password;
	private String code;
	private String profileurl;
	private boolean isactive;
	private Role role;
}
