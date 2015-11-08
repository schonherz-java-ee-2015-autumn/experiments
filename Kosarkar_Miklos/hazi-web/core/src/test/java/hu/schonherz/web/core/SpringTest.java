package hu.schonherz.web.core;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.schonherz.web.core.authentication.Authentication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/core-spring.xml" })
public class SpringTest {
	JdbcTemplate jdbcTemplate;
	Authentication authentication;

	@Test
	public void test() {
		assertNotNull(jdbcTemplate);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Test
	public void AuthenticationTest() {
		assertTrue(authentication.isSuccessfulAuthentication("kosimiki", "Evangelion2"));
	}
	@Autowired
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

}
