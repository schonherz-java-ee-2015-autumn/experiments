package hu.schonherz.kepzes.java.web;

import java.util.ArrayList;

public class Data {
	static ArrayList<RegisterData> users = new ArrayList<RegisterData>();
	
	public Data() {
		
	}
	static void newUser(RegisterData user){
		users.add(user);
	}
	static ArrayList<RegisterData> getUsers() {
		return users;
	}
}
