package hu.schonherz.web.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.schonherz.common.User;
import hu.schonherz.common.UserDAO;
import hu.schonherz.common.UserManager;

public class UserManagerWithDAO implements UserManager{
	private UserDAO userDAO;
	
	@Autowired
	public UserManagerWithDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public void saveUser(User user) {
		userDAO.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.getAllUsers();
		
	}

	@Override
	public User findUserByName(String username) {
		return userDAO.getUserByUsername(username);
	}

	@Override
	public List<User> getUsers(String searchFor, int from, int lenght, String orderBy, String orderDirection) {
		return  userDAO.getUsers(searchFor, from, lenght, orderBy, orderDirection);
	}

}
