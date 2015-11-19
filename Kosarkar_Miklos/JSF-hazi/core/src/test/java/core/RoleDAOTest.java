package core;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.dao.RoleDAO;
import hu.schonherz.java.entities.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test-core.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RoleDAOTest {
	
	@Autowired
	RoleDAO roleDAO;
	
	
	@Test
	public void test1(){
		Role role = new Role();
		role.setName("USER_ROLE");
		Role roleReturn  = roleDAO.save(role);
	}

}
