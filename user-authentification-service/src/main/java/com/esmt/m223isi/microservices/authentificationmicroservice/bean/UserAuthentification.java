package com.esmt.m223isi.microservices.authentificationmicroservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAuthentification {
	
	@Id
	private long id;
	
	@Column(name="user_login")
	private String login;
	
	@Column(name="user_password")
	private String password; 
	
	
	public UserAuthentification() {}


	public UserAuthentification(long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
		
}
	
