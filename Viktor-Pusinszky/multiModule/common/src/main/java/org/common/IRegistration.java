package org.common;

import java.util.List;


public interface IRegistration {

	public void saveRegistration(UserDAO user);
	
	public List<UserDAO> getAllUser();
	
	public UserDAO findUserByName();
	
}
