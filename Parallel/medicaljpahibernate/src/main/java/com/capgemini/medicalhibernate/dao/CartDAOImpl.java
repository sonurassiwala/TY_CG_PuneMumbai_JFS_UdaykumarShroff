package com.capgemini.medicalhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.exception.MedicalException;

public class CartDAOImpl implements CartDAO {

	@Override
	public boolean addCart(CartBean cartBean) {

		boolean isAdd = false;

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(cartBean);
			System.out.println("Added Successfully....!!");
			isAdd = true;
			transaction.commit();
		} catch (Exception e) {
			throw new MedicalException("Unable to Add to Cart");
		}

		return isAdd;
	}

	@Override
	public List<CartBean> getCart(int id) {

		try {
			String jpql = "from CartBean where userId =: uid ";
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			Query query = entitymanager.createQuery(jpql);
			query.setParameter("uid", id);
			List<CartBean> cl = query.getResultList();
			return cl;
		} catch (Exception e) {
			throw new MedicalException("No items found in Cart");
		}
	}

	@Override
	public boolean removeCart(int id) {

		try {
			CartBean cartBean = new CartBean();
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			String jpql = "Delete from CartBean where userId = :id";
			Query query = entitymanager.createQuery(jpql);
			query.setParameter("id", id);
			query.executeUpdate();
			entitytransaction.commit();

			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to remove from Cart");
		}
	}

}
