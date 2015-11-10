package org.common;

import java.util.List;


public interface IRegistration {

	public void saveRegistration(UserDTO user);
	
	public List<UserDTO> getAllUser();
	
	public UserDTO findUserByName(String name);
	
}
