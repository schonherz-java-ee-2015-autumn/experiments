package hu.neuron.data;

import java.util.ArrayList;

public class RegisteredUsers {
	public static ArrayList<User> users = new ArrayList<User>();

	public RegisteredUsers() {

	}

	public static void addUser(User user) {
		users.add(user);
	}

	public static ArrayList<User> getUsers() {
		return users;
	}
}