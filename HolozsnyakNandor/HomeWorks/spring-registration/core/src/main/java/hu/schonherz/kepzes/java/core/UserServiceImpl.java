package hu.schonherz.kepzes.java.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.kepzes.java.common.CheckerDAO;
import hu.schonherz.kepzes.java.common.UserDAO;
import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.common.UserException;
import hu.schonherz.kepzes.java.common.UserVO;
import hu.schonherz.kepzes.java.core.tools.Encryptor;
import hu.schonherz.kepzes.java.core.tools.Tools;

@Component
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired(required = true)
	private UserDAO userDao;
	@Autowired
	private CheckerDAO checkerDao;
	@Autowired
	private Encryptor passwordEncryptor;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	private Tools tools = new Tools();

	@Override
	@Transactional(readOnly = false)
	public void saveUser(UserDTO user) throws ServiceException {
		try {
			userDao.saveUser(user);
		} catch (UserException e) {
			System.out.println("Exception in service " + e);
			throw new ServiceException(e);
		}
	}

	@Override
	public void updateUser(UserDTO user) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(UserDTO user) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserDTO> getUsers(String orderBy, String orderByMode) throws ServiceException {
		String ordBy = tools.determinateOrderBy(orderByMode);
		System.out.println(ordBy);
		try {
			return userDao.getUsers(ordBy, orderByMode);
		} catch (UserException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UserDTO getUserById(long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUserByUserName(String userName) throws ServiceException {
		return checkerDao.checkUserByUsername(userName);
	}

	@Override
	public boolean checkUserByEmail(String eMail) throws ServiceException {
		return checkerDao.checkUserByEmail(eMail);
	}

	public String encryptPassword(String password) {
		return passwordEncryptor.encryptPassword(password);
	}

	public UserDTO loginUser(String username, String password) {
		//String enCryptedPassword = passwordEncryptor.encryptPassword(password);
		//System.out.println("enCryptedPassword:" + enCryptedPassword);
		UserVO user = new UserVO(username, password);
		UserDTO requestedUser;
		try {
			requestedUser = userDao.signInUser(user);
			if (requestedUser != null) {
				return requestedUser;
			} else {
				return null;
			}
		} catch (UserException e) {
			return null;
		}
	}

}
