package org.common;

public class UserDTO {
	
	private String name;
	private String password;
	private String email;
	private String date;
	
	public UserDTO(String name, String password, String email, String date) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.date = date;
	}

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
