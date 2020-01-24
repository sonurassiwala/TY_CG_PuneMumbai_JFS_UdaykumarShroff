package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.UserBean;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public UserBean getUser(int userId) {

		EntityManager entityManager = emf.createEntityManager();
		UserBean userBean = entityManager.find(UserBean.class, userId);
		entityManager.close();

		return userBean;
	}

	@Override
	public UserBean loginUser(String email, String userPassword) {

		EntityManager entityManager = emf.createEntityManager();
		String jpql = "from UserBean where userEmail =: userEmail and userPassword =: userPassword";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userEmail", email);
		query.setParameter("userPassword", userPassword);
		UserBean userBean = null;

		try {
			userBean = (UserBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userBean;
	}

	@Override
	public boolean addUser(UserBean userBean) {

		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(userBean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isUpdated = false;
		UserBean userBean2 = manager.find(UserBean.class, userBean.getUserId());
		if(userBean2 != null) {
			
			if(userBean.getUserName() != null) {
				userBean2.setUserName(userBean.getUserName());
			}
			
			if(userBean.getUserEmail() != null) {
				userBean2.setUserEmail(userBean.getUserEmail());
			}
			
			if(userBean.getUserPassword() != null) {
				userBean2.setUserPassword(userBean.getUserPassword());
			}
			
			if(userBean.getUserType() != null) {
				userBean2.setUserType(userBean.getUserType());
			}
			

			try {
				tx.begin();
				manager.persist(userBean2);
				tx.commit();
				isUpdated = true;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();
			
		}
		return isUpdated;
		
	}

	@Override
	public boolean deleteUser(int userId) {
		
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			UserBean userBean= entityManager.find(UserBean.class, userId);
			entityManager.remove(userBean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<UserBean> getAllUser() {

		EntityManager manager = emf.createEntityManager();
		String jpql = "from UserBean";
		Query query = manager.createQuery(jpql);
		
		List<UserBean> userList = null;
		try {
			userList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
		
	}

}
