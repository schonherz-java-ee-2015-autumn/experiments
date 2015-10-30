package org.common;

public class User {
	String name;
	String password;
	String email;
	String date;
	
	public User(String name, String password, String email, String date) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.date = date;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
