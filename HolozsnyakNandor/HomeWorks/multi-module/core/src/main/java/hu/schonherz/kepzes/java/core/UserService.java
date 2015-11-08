package hu.schonherz.kepzes.java.core;

import java.util.List;

import hu.schonherz.kepzes.java.common.UserDTO;


public interface UserService {
	void saveUser(UserDTO user) throws ServiceException;
	void updateUser(UserDTO user) throws ServiceException;
	void deleteUser(UserDTO user) throws ServiceException;
	List<UserDTO> getUsers(String orderBy, String orderByMode) throws ServiceException;
	UserDTO getUserById(long id) throws ServiceException;
}
