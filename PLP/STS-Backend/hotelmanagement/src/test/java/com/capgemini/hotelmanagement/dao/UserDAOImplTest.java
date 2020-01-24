package com.capgemini.hotelmanagement.dao;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.hotelmanagement.beans.UserBean;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserDAOImplTest {

	@Autowired
	private UserDAO userDAO;
	
	@Test
	void testUserRegistration() {
		UserBean userBean = new UserBean();
		userBean.setUserName("Komal");
		userBean.setEmail("komal@gmail.com");
		userBean.setPhoneNumber("9630852074");
		userBean.setNationality("Indian");
		userBean.setPassword("Komal@1997");
		userBean.setGender("Female");
		userBean.setUserType("user");
		TestCase.assertTrue(userDAO.userRegistration(userBean));
	}

	@Test
	void testUserLogin() {
		UserBean userBean = new UserBean();
		userBean.setEmail("komal13@gmail.com");
		userBean.setPassword("Komal@1997");
		TestCase.assertNotNull(userDAO.userLogin(userBean.getEmail(), userBean.getPassword()));
	}

	@Test
	void testResetPassword() {
		UserBean userBean = new UserBean();
		userBean.setEmail("komal13@gmail.com");
		userBean.setPhoneNumber("9630852074");
		userBean.setPassword("Komal19@97");
		TestCase.assertNotNull(userDAO.resetPassword(userBean.getEmail(), userBean.getPhoneNumber(), userBean.getPassword()));
	}

	@Test
	void testUpdateProfile() {
		UserBean userBean = new UserBean();
		userBean.setUserId(13);
		userBean.setUserName("Komal");
		userBean.setEmail("komal13@gmail.com");
		userBean.setPhoneNumber("9630852074");
		userBean.setNationality("Indian");
		userBean.setPassword("Komal@1997");
		userBean.setGender("F");
		userBean.setUserType("user");
		TestCase.assertTrue(userDAO.updateProfile(userBean));
	}

	@Test
	void testShowProfile() {
		UserBean userBean = new UserBean();
		userBean.setUserId(13);
		TestCase.assertNotNull(userDAO.showProfile(userBean.getUserId()));
	}

	@Test
	void testShowAdmin() {
		UserBean userBean = new UserBean();
		userBean.setUserType("Admin");
		TestCase.assertNotNull(userDAO.showManager());
	}

	@Test
	void testShowUser() {
		UserBean userBean = new UserBean();
		userBean.setUserType("User");
		TestCase.assertNotNull(userDAO.showUser());
	}

	@Test
	void testRemoveUser() {
		UserBean userBean = new UserBean();
		userBean.setUserId(13);
		TestCase.assertTrue(userDAO.removeUser(userBean.getUserId()));
	}

	@Test
	void testEmailPresent() {
		UserBean userBean = new UserBean();
		userBean.setEmail("diksha@gmail.com");
		TestCase.assertNotNull(userDAO.emailPresent(userBean.getEmail()));
	}

}
