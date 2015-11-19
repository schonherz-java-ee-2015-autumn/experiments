package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.UserConverter;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.dao.RoleDao;
import hu.schonherz.java.dao.UserDao;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Override
	public UserVO findUserByName(String name) throws Exception {
		User user = userDao.findByUsername(name);
		return UserConverter.toVo(user);
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		User user = userDao.save(UserConverter.toEntity(userVO));
		List<Role> roles = user.getRoles();

		if (roles == null || roles.isEmpty()) {
			roles = new ArrayList<>();
		}

		Role role = extracted();

		roles.add(role);

		user.setRoles(roles);

		userDao.save(user);
	}

	private Role extracted() {
		Role role = roleDao.findByName("USER_ROLE");
		if (role == null) {
			role = new Role();
			role.setName("USER_ROLE");
			role = roleDao.save(role);
		}
		return role;
	}



	@Override
	public UserVO loginUser(UserVO userVo) {

		User user = UserConverter.toEntity(userVo);
		List<Role> roles = user.getRoles();
		UserVO userVO = new UserVO();
		user.setRoles(roles);
		User getUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (getUser == null) {
			return null;
		} else {
			userVO = UserConverter.toVo(getUser);
			return userVO;
		}
	}

	@Override
	public List<UserVO> findAll(Sort sort) {
		List<UserVO> users = new ArrayList<>();
		List<User> queriedUsers = userDao.findAll(sort);
		for (User user : queriedUsers) {
			users.add(UserConverter.toVo(user));
		}
		return users;
	}

}
