package hu.schonherz.webapp;

import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private static ArrayList<User> USERS=new ArrayList();
	
	private String username;
	private String password;
	private Date DateofBirth;
	private String email;
	private ArrayList<User> friends;
	
	@SuppressWarnings("deprecation")
	public User(String un,String pwd,String DoB,String mail,String fr){
		username=un;
		password=pwd;
		DateofBirth=new Date();
		DateofBirth.setYear(Integer.parseInt(DoB.substring(0, DoB.indexOf('.'))));
		DateofBirth.setMonth(Integer.parseInt(DoB.substring(DoB.indexOf('.')+1, DoB.lastIndexOf('.'))));
		DateofBirth.setDate(Integer.parseInt(DoB.substring(DoB.lastIndexOf('.')+1, DoB.length()-1)));
		email=mail;
		User friend=findUser(fr);
		if(friend!=null)
			friends.add(friend);
	}
	
	@SuppressWarnings("deprecation")
	public User(String un,String pwd,String DoB,String mail){
		username=un;
		password=pwd;
		DateofBirth=new Date();
		DateofBirth.setYear(Integer.parseInt(DoB.substring(0, DoB.indexOf('.'))));
		DateofBirth.setMonth(Integer.parseInt(DoB.substring(DoB.indexOf('.')+1, DoB.lastIndexOf('.'))));
		DateofBirth.setDate(Integer.parseInt(DoB.substring(DoB.lastIndexOf('.')+1, DoB.length()-1)));
		email=mail;
	}
	
	
	
	public static ArrayList<User> getUSERS() {
		return USERS;
	}

	public static void setUSERS(ArrayList<User> uSERS) {
		USERS = uSERS;
	}

	public static User findUser(String name){
		for(User u:USERS)
			if ((u!=null) && u.username.equals(name))
				return u;
		return null;
	}
	
	public static void AddUser(User u){
		USERS.add(u);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateofBirth() {
		return DateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		DateofBirth = dateofBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
}
