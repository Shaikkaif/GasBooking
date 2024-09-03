package com.example.demo.security;

import com.example.demo.entity.User;

public class JwtResponse {
	
	public JwtResponse() {
		super();
	}
	public JwtResponse(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}
	private String token;
	private User user;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getCustomer() {
		return user;
	}
	public void setCustomer(User user) {
		this.user = user;
	}

}