package regi.hazi;

import java.util.List;

import hu.schonherz.kepzes.java.common.UserDTO;

public interface RegistrationUtil {

	public void saveRegistration(UserDTO user);

	public List<UserDTO> getAllUser();
	//public void getAllUsertoJSON(int FromId,int toId,String orderedBy);
	public UserDTO findUserByName();
}
