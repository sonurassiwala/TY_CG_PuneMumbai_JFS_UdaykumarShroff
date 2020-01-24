package com.capgemini.medicalhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.medicalhibernate.dto.CartBean;
import com.capgemini.medicalhibernate.dto.ItemBean;
import com.capgemini.medicalhibernate.dto.OrderBean;
import com.capgemini.medicalhibernate.exception.MedicalException;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public boolean addOrder(OrderBean bean) {

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(bean);
			System.out.println("Added Successfully....!!");
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new MedicalException("Unable to add order");
		}

		return true;
	}

	@Override
	public List<OrderBean> viewOrder(int userId) {

		String jpql = "from OrderBean where userId =: uid ";
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("uid", userId);
		try {
			List<OrderBean> ol = query.getResultList();
			return ol;
		} catch (Exception e) {
			throw new MedicalException("No order found");
		}
	}

	@Override
	public OrderBean viewLastOrder() {

		String jpql = "select max(orderId) from OrderBean";
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		Query query = entitymanager.createQuery(jpql);

		OrderBean bean = new OrderBean();
		bean.setOrderId(bean.getOrderId());

		return null;
	}

	@Override
	public boolean insertItem(int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemBean> viewOrderItems(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
