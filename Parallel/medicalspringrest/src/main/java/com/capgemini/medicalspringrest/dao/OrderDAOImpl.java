package com.capgemini.medicalspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringrest.bean.OrderBean;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addOrder(OrderBean bean) {
		
		try {
			EntityManager entityManager = emf.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(bean);
			System.out.println("Added Successfully....!!");
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid Credentials!!");
		}
		
		return true;
		
	}

	@Override
	public List<OrderBean> viewOrder(int userId) {
		String jpql = "from OrderBean where userId =: uid ";
		EntityManager entitymanager = emf.createEntityManager();
		Query query = entitymanager.createQuery(jpql);
		query.setParameter("uid", userId);
		List<OrderBean> ol = query.getResultList();
		return ol;
	}

}
