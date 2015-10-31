package hu.schonherz.common;

import java.util.List;

public interface UserManager {

	public void saveUser(User user);

	public List<User> getAllUser();

	public User findUserByName(String username);
	
	public List<User> getUsers(String searchFor, int from, int lenght, String orderBy, String orderDirection);
	
}
