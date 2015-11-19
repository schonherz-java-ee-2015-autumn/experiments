package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.dao.RoleDAO;
import hu.schonherz.java.dao.UserDAO;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImp implements UserService{

	@Autowired
	UserDAO userDAO;
	@Autowired
	RoleDAO roleDAO;
	
	@Override
	public UserVO findUserByName(String name) throws Exception {
		User user = userDAO.findByUsername(name);
		return  UserConverter.toVO(user);
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		User user = userDAO.save(UserConverter.toEntity(userVO));
		List<Role> roles = user.getRoles();
		if(roles==null || roles.isEmpty()){
			roles = new ArrayList<>();
		}
		
		Role role = getUserRole();
		
		roles.add(role);
		user.setRoles(roles);
		
		userDAO.save(user);
		
		
	}

	private Role getUserRole() {
		Role role  = roleDAO.findByName("USER_ROLE");
		
		
		if(role == null){
			role = new Role();
			role.setName("USER_ROLE");
			role = roleDAO.save(role);
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
		// TODO Auto-generated method stub
		
	}

}
