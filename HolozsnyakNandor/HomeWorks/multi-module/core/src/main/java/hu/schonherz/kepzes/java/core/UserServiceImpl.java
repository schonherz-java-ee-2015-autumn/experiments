package hu.schonherz.kepzes.java.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.kepzes.java.common.UserDAO;
import hu.schonherz.kepzes.java.common.UserDTO;
import hu.schonherz.kepzes.java.common.UserException;

@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true, rollbackFor = ServiceException.class, propagation = Propagation.REQUIRED)

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;
	private Tools tools = new Tools();

	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(UserDTO user) throws ServiceException {
		ApplicationContext context = new ClassPathXmlApplicationContext("/datasource-with-transaction.xml",
				UserDAOImpl.class);
		userDao = (UserDAO) context.getBean("userDao");
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
		ApplicationContext context = new ClassPathXmlApplicationContext("/datasource-with-transaction.xml",
				UserDAOImpl.class);
		userDao = (UserDAO) context.getBean("userDao");
		
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

}
