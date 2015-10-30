package org.common;

import java.util.List;

public interface RegistrationUtil {

	public void saveRegistration(User user);

	public List<User> getAllUser();

	public User findUserByName(String name);
}
