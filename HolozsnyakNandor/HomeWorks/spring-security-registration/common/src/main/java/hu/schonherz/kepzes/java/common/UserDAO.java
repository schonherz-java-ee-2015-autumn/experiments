package hu.schonherz.kepzes.java.common;

import java.util.List;

import javax.sql.DataSource;

public interface UserDAO {
	
	void saveUser(UserDTO user) throws UserException;
	void updateUser(UserDTO user) throws UserException;
	void deleteUser(UserDTO user) throws UserException;
	List<UserDTO> getUsers(String orderBy, String orderByMode) throws UserException;
	UserDTO getUserById(long id) throws UserException;
	UserDTO signInUser(UserVO user) throws UserException;
	UserDTO getUserByName(String username) throws UserException;
	
}
