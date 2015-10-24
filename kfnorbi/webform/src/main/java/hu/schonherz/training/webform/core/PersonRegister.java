package hu.schonherz.training.webform.core;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import hu.schonherz.training.webform.bean.Person;

public class PersonRegister {

	public static final List<Person> registratedUsers = new CopyOnWriteArrayList<Person>();
	public static final Set<String> userNames = new CopyOnWriteArraySet<String>();

	public static boolean isOccupied(String userName) {
		if (userNames.contains(userName)) {
			return true;
		} else {
			return false;
		}
	}

	public static void register(Person p) {
		registratedUsers.add(p);
		userNames.add(p.getUserName());
	}

}
