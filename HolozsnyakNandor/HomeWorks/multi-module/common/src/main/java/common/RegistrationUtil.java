package common;

import java.util.List;

public interface RegistrationUtil {

	public void saveRegistration(User user);

	public List<User> getAllUser();
	//public void getAllUsertoJSON(int FromId,int toId,String orderedBy);
	public User findUserByName();
}
