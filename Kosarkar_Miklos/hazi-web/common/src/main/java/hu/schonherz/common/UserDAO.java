package hu.schonherz.common;

import java.util.List;

public interface UserDAO {
	public void save(User user);
	public User getUserByUsername(String username);
	public List<User> getAllUsers();
	public List<User> getUsers(String searchFor, int from, int lenght, String orderBy, String orderDirection);
}
