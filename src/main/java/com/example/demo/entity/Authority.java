package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;


public class Authority implements GrantedAuthority{

	public Authority() {
		super();
	}

	public Authority(String authority) {
		super();
		this.authority = authority;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String authority;

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
