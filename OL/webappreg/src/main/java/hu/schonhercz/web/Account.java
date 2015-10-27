package hu.schonhercz.web;

import java.util.ArrayList;

public class Account {
	
	private static ArrayList<Account> accountDB = new ArrayList<>();

	private String userName;
	private String password;
	private String fullName;
	private String eMail;
	private String birthPlace;
	private String bornDate;
	
	public Account(String userName, String password, String fullName, String eMail, String birthPlace, String bornDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.eMail = eMail;
		this.birthPlace = birthPlace;
		this.bornDate = bornDate;
		
		accountDB.add(this);
	}

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



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public String getBirthPlace() {
		return birthPlace;
	}



	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}



	public String getBornDate() {
		return bornDate;
	}



	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}


	public static ArrayList<Account> getAccountDB() {
		return accountDB;
	}
	
	
}
