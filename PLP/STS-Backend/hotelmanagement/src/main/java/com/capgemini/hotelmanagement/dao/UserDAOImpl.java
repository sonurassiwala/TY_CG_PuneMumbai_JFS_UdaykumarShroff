package com.capgemini.hotelmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.hotelmanagement.beans.UserBean;
import com.capgemini.hotelmanagement.exception.EmailAlreadyExistException;
import com.capgemini.hotelmanagement.exception.EmailNotExistException;
import com.capgemini.hotelmanagement.exception.IncorrectPasswordException;
import com.capgemini.hotelmanagement.exception.PasswordException;
import com.capgemini.hotelmanagement.exception.UserNotFoundException;

@Repository
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean userRegistration(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean isRegister = false;

		try {
			transaction.begin();
			// Storing new user using persist
			entityManager.persist(userBean);
			transaction.commit();
			isRegister = true;

		} catch (Exception e) {
			throw new EmailAlreadyExistException();
		}
		return isRegister;
	}// End of userRegistration()

	@Override
	public UserBean userLogin(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserBean userBean = null;

		String jpql = "FROM UserBean WHERE email =: email AND password =: password";
		Query query = entityManager.createQuery(jpql);
		// setting parameters
		query.setParameter("email", email);
		query.setParameter("password", password);
		try {
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new IncorrectPasswordException();
		}
		return userBean;
	}// End of userLogin()

	@Override
	public boolean resetPassword(String email, String phoneNumber, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isUpdated = false;

		try {
			String jpql = "UPDATE UserBean SET password =: password WHERE email =: email AND phoneNumber =: phoneNumber";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("password", password);
			query.setParameter("email", email);
			query.setParameter("phoneNumber", phoneNumber);
			entityTransaction.begin();
			int count = query.executeUpdate();
			if (count > 0) {
				isUpdated = true;
			}
			entityTransaction.commit();

		} catch (Exception e) {
			throw new PasswordException();
		}
		return isUpdated;
	}// End of resetPassword()

	@Override
	public boolean updateProfile(UserBean userBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserBean existingUser = entityManager.find(UserBean.class, userBean.getUserId());
		boolean isUpdated = false;

		if (existingUser != null) {
			int userId = userBean.getUserId();
			if (userId > 0) {
				existingUser.setUserId(userId);
			}

			String userName = userBean.getUserName();
			if (userName != null) {
				existingUser.setUserName(userName);
			}

			String email = userBean.getEmail();
			if (email != null) {
				existingUser.setEmail(email);
			}

			String phoneNumber = userBean.getPhoneNumber();
			if (phoneNumber != null) {
				existingUser.setPhoneNumber(phoneNumber);
			}

			String nationality = userBean.getNationality();
			if (nationality != null) {
				existingUser.setNationality(nationality);
			}

			String password = userBean.getPassword();
			if (password != null) {
				existingUser.setPassword(password);
			}

			String gender = userBean.getGender();
			if (gender != null) {
				existingUser.setGender(gender);
			}

			String userType = userBean.getUserType();
			if (userType != null) {
				existingUser.setUserType(userType);
			}
		}

		try {
			entityTransaction.begin();
			entityManager.persist(existingUser);
			entityTransaction.commit();
			isUpdated = true;

		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return isUpdated;
	}// End of updateProfile()

	@Override
	public UserBean showProfile(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		UserBean userBean = null;
		try {
			String jpql = "FROM UserBean WHERE userId =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			// Getting single user Data
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return userBean;
	}// End of showProfile()

	@Override
	public List<UserBean> showManager() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<UserBean> adminList = null;
		try {
			String userType = "Manager";
			String jpql = "FROM UserBean WHERE userType =: userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			adminList = query.getResultList();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return adminList;
	}// End of showAdmin()

	@Override
	public List<UserBean> showUser() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<UserBean> userList = null;

		try {
			String userType = "User";
			String jpql = "FROM UserBean WHERE userType =: userType";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userType", userType);
			userList = query.getResultList();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return userList;
	}// End of showUser()

	@Override
	public boolean removeUser(int userId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		boolean isDeleted = false;
		try {
			entityTransaction.begin();
			UserBean userBean = entityManager.find(UserBean.class, userId);
			entityManager.remove(userBean);
			isDeleted = true;
			entityTransaction.commit();
		} catch (Exception e) {
			throw new UserNotFoundException();
		}
		return isDeleted;
	}// End of removeUser()

	@Override
	public boolean emailPresent(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM UserBean";
			Query query = entityManager.createQuery(jpql);
			List<UserBean> userList = (List<UserBean>) query.getResultList();
			for (UserBean userBean : userList) {
				if (email.equals(userBean.getEmail())) {
					unique = true;
					return unique;
				}
			}
		} catch (Exception e) {
			throw new EmailNotExistException();
		}
		return unique;
	}// End of emailList()

	@Override
	public boolean passwordChecker(String email, String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		boolean unique = false;
		try {
			String jpql = "FROM UserBean WHERE email =: email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			UserBean userBean = (UserBean) query.getSingleResult();
			if (password.equals(userBean.getPassword())) {
				unique = true;
			}
			
		} catch (Exception e) {
			throw new IncorrectPasswordException();
		}
		return unique;
	}//End of passwordPresent()

}// End of Class
