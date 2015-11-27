package hu.neuron.java.core.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.dao.RoleDao;
import hu.schonherz.java.dao.UserDao;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class DataGenerate {

	private static final Logger logger = Logger.getLogger(DataGenerate.class);

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Test
	public void test1GenerateUsers() {
		try {
			Role userRole = roleDao.findByName("ROLE_USER");
			if (userRole == null) {
				userRole = new Role();
				userRole.setName("ROLE_USER");
				roleDao.save(userRole);
			}
			ArrayList<User> users = new ArrayList<>();

			JsonReader jsonReader = new JsonReader();
			JSONObject json = jsonReader.readJsonFromUrl("https://randomuser.me/api/?results=20");
			JSONArray array = json.getJSONArray("results");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				RandomUser randomUser = new RandomUser(jsonObject.getJSONObject("user"));

				User user = new User();
				user.setUsername(randomUser.getUsername());
				BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
				String encPassword = bCryptPasswordEncoder.encode("password");

				user.setPassword(encPassword);

				user.setEmail(randomUser.getEmail());
				user.setPhone(randomUser.getPhone());
				user.setPersonFirstName(randomUser.getPersonFirstName());
				user.setPersonLastName(randomUser.getPersonLastName());

				URL url = new URL(randomUser.getPictureMedium());
				BufferedImage bufferedImage = ImageIO.read(url);

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "jpg", baos);
				baos.flush();
				byte[] data = baos.toByteArray();
				baos.close();

				user.setImage(data);

				user.setRoles(new ArrayList<>());
				user.getRoles().add(userRole);

				users.add(user);
				System.out.println(user.getUsername());

				userDao.save(users);

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

}
