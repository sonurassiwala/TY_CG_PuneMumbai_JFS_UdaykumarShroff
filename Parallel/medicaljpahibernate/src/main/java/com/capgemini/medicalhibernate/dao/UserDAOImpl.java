package com.capgemini.medicalhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.exception.MedicalException;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserBean loginUser(String email, String password) {

		try {

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
			EntityManager em = emf.createEntityManager();
			String jpql = "from UserBean where email =: email and password =: password";
			Query query = em.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			List<UserBean> ul = query.getResultList();
			for (UserBean ub : ul) {
//				System.out.println(ub.getUserId());
//				System.out.println(ub.getUserName());
//				System.out.println(ub.getUserEmail());
//				System.out.println(ub.getUserPassword());
//				System.out.println(ub.getUserType());
				return ub;
			}

		} catch (Exception e) {
			throw new MedicalException("Unable to Login User");
		}

		return null;
	}

	@Override
	public boolean registerUser(String name, String email, String password) {

		try {
			UserBean userBean = new UserBean();
			userBean.setUserName(name);
			userBean.setUserEmail(email);
			userBean.setUserPassword(password);
			userBean.setUserType("user");
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(userBean);
			System.out.println("Register Successfully....!!");
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MedicalException("Unable to register user");
		}

		return true;
	}

	@Override
	public boolean deleteUser(UserBean userBean) {

		try {
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			userBean = entitymanager.find(UserBean.class, userBean.getUserId());
			entitymanager.remove(userBean);
			entitytransaction.commit();
			
			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to delete user");
		}
		
	}

	@Override
	public List<UserBean> getUser() {

		try {
			String jpql = "from UserBean where userType = 'user'";
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			Query query = entitymanager.createQuery(jpql);
			List<UserBean> ul = query.getResultList();
			
				return ul;
			
		} catch (Exception e) {
			throw new MedicalException("Unable to Fetch users");
		}
	}

	@Override
	public boolean adminRegisterUser(String name, String email, String password, String type) {
		
		try {
			UserBean userBean = new UserBean();
			userBean.setUserName(name);
			userBean.setUserEmail(email);
			userBean.setUserPassword(password);
			userBean.setUserType(type);
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(userBean);
			System.out.println("Register Successfully....!!");
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new MedicalException("Unable to add user");
		}

		
		return true;
	}

	@Override
	public boolean changePassword(UserBean userBean) {
		
		try {
			int id = userBean.getUserId();
			String pswrd = userBean.getUserPassword();
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			UserBean userBean2 = entitymanager.find(UserBean.class, userBean.getUserId());
			if(userBean2 != null) {
				if(userBean.getUserPassword() != null) {
					userBean2.setUserPassword(userBean.getUserPassword());
				}
			}
			
			entitymanager.persist(userBean2);
			entitytransaction.commit();
			
			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to change password");
		}
	}

}
