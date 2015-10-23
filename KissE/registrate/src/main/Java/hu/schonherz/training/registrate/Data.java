package hu.schonherz.training.registrate;

import java.util.ArrayList;

public class Data {

	
	static ArrayList<RegData> users = new ArrayList<RegData>();
	
	public Data(){
		
	}
	static void newUser(RegData user){
		users.add(user);
	}
	static ArrayList<RegData> getUsers(){
		return users;
	}
}

