package com.mindstix.webapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class User {

	String userName;
	String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
