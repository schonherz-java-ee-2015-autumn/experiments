package hu.neuron.java.core.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.dao.RoleDao;
import hu.schonherz.java.entities.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class RoleDaoTest {

	@Autowired
	RoleDao roleDao;

	@Test
	public void test1() {
		Role role = new Role();
		role.setName("USER_ROLE");
		Role roleReturn = roleDao.save(role);
		System.out.println(roleReturn.getId());
	}

	@Test
	public void test2() {
		
	}

}
