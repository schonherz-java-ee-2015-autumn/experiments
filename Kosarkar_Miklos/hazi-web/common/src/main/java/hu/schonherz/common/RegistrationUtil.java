package hu.schonherz.common;

import java.util.List;

public interface RegistrationUtil {

	public void saveUser(User user);

	public List<User> getAllUser();

	public User findUserByName(String username);
}
