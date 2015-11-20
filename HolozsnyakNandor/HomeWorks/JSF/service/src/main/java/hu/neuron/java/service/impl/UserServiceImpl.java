package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("Username in registartionUser:" + userVO.getUsername());
		User user = userDao.save(UserConverter.toEntity(userVO));
		List<Role> roles = user.getRoles();

		if (roles == null || roles.isEmpty()) {
			roles = new ArrayList<>();
		}

		Role role = extracted();

		roles.add(role);

		user.setRoles(roles);
		System.out.println("Username in registartionUser before save:" + user.getUsername());
		// csak egy update lesz vagyis az user_role_switch táblába fog
		// beszúródni
		userDao.save(user);
	}

	private Role extracted() {
		Role role = roleDao.findByName("ROLE_USER");
		if (role == null) {
			role = new Role();
			role.setName("ROLE_USER");
			role = roleDao.save(role);
		}
		return role;
	}

	@Override
	public List<UserVO> getUserList(int i, int pageSize, String sortField, int dir, String filter,
			String filterColumnName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getUserCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(UserVO selectedUser) {

	}

	@Override
	public boolean loginUser(UserVO userVo) {
		System.out.println("uservo in login:" + userVo.getUsername() + " " + userVo.getPassword());
		User user = UserConverter.toEntity(userVo);
		List<Role> roles = user.getRoles();
		System.out.println("user in login:" + user.getUsername() + " " + user.getPassword());
		user.setRoles(roles);
		User getUser = userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (getUser == null) {
			System.out.println("Nincs ilyen user!");
			return false;
		} else {
			System.out.println("Van ilyen user!");
			return true;
		}
		// System.out.println(getUser.toString());
		// return getUser != null ? true : false;
	}

	@Override
	public List<UserVO> findUsersContaining(String username) {
		List<UserVO> users = new ArrayList<>();
		List<User> queriedUsers = userDao.findByUsernameContaining(username);
		for (User user : queriedUsers) {
			users.add(UserConverter.toVo(user));
		}
		return users;
	}

	@Override
	public List<UserVO> getAllUsers() {
		List<User> queriedUsers = userDao.getAllUsersFromTable();
		List<UserVO> users = new ArrayList<>();

		for (User user : queriedUsers) {
			users.add(UserConverter.toVo(user));
		}
		return users;
	}

	@Override
	public void updateUser(UserVO updatableUser) {
		userDao.saveAndFlush(UserConverter.toEntity(updatableUser));
	}

}
