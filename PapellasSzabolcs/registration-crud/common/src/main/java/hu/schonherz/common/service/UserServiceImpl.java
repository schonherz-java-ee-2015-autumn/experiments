package hu.schonherz.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.common.dao.PersistenceException;
import hu.schonherz.common.dao.UserDAO;
import hu.schonherz.common.dto.UserDTO;

public class UserServiceImpl implements UserService {

	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = false)
	@Override
	public Long saveUser(UserDTO user) throws ServiceException {
		try {
			return userDao.saveUser(user);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UserDTO getUser(int userId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int userId) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> getAllUser() throws ServiceException {
		try {
			return this.userDao.getAllUser();
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UserDTO isUserExists(String userName) throws ServiceException {
		try {
			return this.userDao.isUserExists(userName);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkUserByName(String userName) throws ServiceException {
		try {
			return this.userDao.checkUserByName(userName);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean checkUserByMail(String email) throws ServiceException {
		try {
			return this.userDao.checkUserByMail(email);
		} catch (PersistenceException e) {
			throw new ServiceException(e);
		}
	}

}
