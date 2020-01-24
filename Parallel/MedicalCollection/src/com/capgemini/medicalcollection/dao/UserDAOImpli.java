package com.capgemini.medicalcollection.dao;

import java.util.List;
import java.util.Set;

import com.capgemini.medicalcollection.bean.UserBean;
import com.capgemini.medicalcollection.controller.RegisterUser;
import com.capgemini.medicalcollection.database.UserDataBase;
import com.capgemini.medicalcollection.exception.MedicalException;

public class UserDAOImpli implements UserDAO {

	UserBean bean;
	UserDataBase dataBase = new UserDataBase();
	List<UserBean> userBeans = dataBase.getUser();

	@Override
	public UserBean login(String email, String password) {
		try {
			for (UserBean userBean : userBeans) {
				if (userBean.getUserEmail().equals(email) && userBean.getUserPassword().equals(password)) {
					bean = userBean;
					break;
				}
			}
			return bean;
		} catch (Exception e) {
			throw new MedicalException("Unable to login user");
		}
	}

	@Override
	public boolean userRegister(String email, String password, String name) {
		try {
			String userType = "user";
			int check = 0;
			int userid = userBeans.size() + 100;
			UserBean b = new UserBean(userid, name, password, userType, email);
			boolean isAdded = false;
			for (UserBean userBean : userBeans) {
				if (b.getUserEmail().equals(userBean.getUserEmail())) {
					check++;
				}
			}
			if (check == 0) {
				userBeans.add(b);
				isAdded = true;
			} else {
				System.out.println("User Already Exist");
				new RegisterUser().userRegister();
			}
			return isAdded;
		} catch (Exception e) {
			throw new MedicalException("Unable to register user");
		}
	}

	@Override
	public boolean adminRegister(String email, String password, String name) {
		try {
			String userType = "admin";
			int userid = userBeans.size() + 100;
			int check = 0;
			UserBean b = new UserBean(userid, name, password, userType, email);
			boolean isAdded = false;
			for (UserBean userBean : userBeans) {
				if (b.getUserEmail().equals(userBean.getUserEmail())) {
					check++;
				}
			}
			if (check == 0) {
				userBeans.add(b);
				isAdded = true;
			} else {
				System.out.println("User Already Exist");
				new RegisterUser().adminRegister(b);
			}

			return isAdded;
		} catch (Exception e) {
			throw new MedicalException("Unable to register user");
		}
	}

	@Override
	public List<UserBean> getUsers() {
		try {
			return dataBase.getUser();
		} catch (Exception e) {
			throw new MedicalException("Unable to fetch users");
		}
	}

	public boolean removeUser(int uid) {
		try {
			boolean isDeleted = false;
			for (UserBean bean : userBeans) {
				if (bean.getUserId() == uid) {
					userBeans.remove(bean);
					isDeleted = true;
					break;
				} else {
					isDeleted = false;
				}
			}
			return isDeleted;
		} catch (Exception e) {
			throw new MedicalException("Unable to remove user");
		}
	}

	@Override
	public boolean changePassword(UserBean bean, String pass) {
		try {
			boolean isChanged = false;
			for (UserBean userBean : userBeans) {
				if (userBean.getUserEmail().equals(bean.getUserEmail())) {
					userBean.setUserPassword(pass);
					isChanged = true;
				}
			}
			return isChanged;
		} catch (Exception e) {
			throw new MedicalException("Unable to change password");
		}
	}

}