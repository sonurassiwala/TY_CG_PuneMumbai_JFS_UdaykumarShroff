package com.capgemini.medicaljpahibernate.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.medicalhibernate.controller.Login;
import com.capgemini.medicalhibernate.dao.CartDAO;
import com.capgemini.medicalhibernate.dao.MedicneDAO;
import com.capgemini.medicalhibernate.dao.MessageDAO;
import com.capgemini.medicalhibernate.dao.UserDAO;
import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.factory.MedicalFactory;

public class UserDAOTest {

	private Login login = null;
	UserDAO userDao = MedicalFactory.getUser();
	MedicneDAO mDao = MedicalFactory.getMedicine();
	CartDAO cDao = MedicalFactory.getcart();
	MessageDAO msgDao = MedicalFactory.getMessage();

	@BeforeEach
	void setObject() {
		login = new Login();
	}

	@Test
	public void loginUserTest() {
		UserBean actual = userDao.loginUser("uday@gmail.com", "uday");
		int expected = 102;
		assertEquals(expected, actual.getUserId());
	}

	@Test
	public void registerUserTest() {
		boolean i = userDao.registerUser("komal", "komal@gmail.com", "komal");
		assertEquals(true, i);
	}

	@Test
	public void registerAdminTest() {
		boolean i = userDao.adminRegisterUser("aishwarya", "aishwarya@gmail.com", "aishwarya", "admin");
		assertEquals(true, i);
	}

	@Test
	public void deleteUserTest() {
		UserBean ub = new UserBean();
		ub.setUserId(175);
		boolean i = userDao.deleteUser(ub);
		assertEquals(true, i);
	}

	@Test
	public void updatePasswordTest() {
		UserBean bean = new UserBean();
		bean.setUserId(125);
		bean.setUserPassword("sumedh");
		boolean ub = userDao.changePassword(bean);
		assertEquals(true, ub);
	}

	@Test
	public void addMedTest() {
		boolean i = mDao.addMedicine("Dolo", 150, 200, "Allopathic");
		assertEquals(true, i);
	}

	@Test
	public void changePrice() {
		MedicineBean mb = new MedicineBean();
		mb.setMedicineCode(801);
		mb.setPrice(350);
		boolean i = mDao.changePrice(mb);
		assertEquals(true, i);
	}

	@Test
	public void removeMedTest() {
		MedicineBean mb = new MedicineBean();
		mb.setMedicineCode(803);
		boolean i = mDao.removeMed(mb);
		assertEquals(true, i);
	}

	@Test
	public void addcartTest() {
		CartBean cb = new CartBean();
		cb.setUserId(127);
		cb.setMedicineCode(804);
		cb.setMedicinePrice(70);
		boolean i = cDao.addCart(cb);
		assertEquals(true, i);
	}

	@Test
	public void sendMessageTest() {
		boolean i = msgDao.sendMessage(127, "Hello Mayuri Here medicine not getting", "question");
		assertEquals(true, i);
	}

	@Test
	public void sendResponse() {
		boolean i = msgDao.sendResponse(127, "Hello Mayuri Thank You", "answer");
		assertEquals(true, i);
	}
}
