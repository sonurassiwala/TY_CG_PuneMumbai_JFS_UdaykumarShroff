package com.capgemini.medicalspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringrest.bean.CartBean;
import com.capgemini.medicalspringrest.bean.MedicineBean;
import com.capgemini.medicalspringrest.bean.UserBean;

@Repository
public class CartDAOImpl implements CartDAO{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean addCart(int userId, int medicineId) {

		int price=0;
		String medicineName = null;
		EntityManager entityManager=emf.createEntityManager();
		EntityTransaction transaction=null;
		boolean isadd=false;


		try {
			transaction=entityManager.getTransaction();
			
			String jpql="from UserBean where userId=:userId";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("userId", userId);

			String jpql1="from MedicineBean where medicineId=:medicineId";
			Query query1=entityManager.createQuery(jpql1);
			query1.setParameter("medicineId",medicineId);
			MedicineBean medicineBean= (MedicineBean) query1.getSingleResult();
			medicineName = medicineBean.getMedicineName();
			price=medicineBean.getPrice();

			CartBean cartBean=new CartBean();
			cartBean.setUserId(userId);
			cartBean.setMedicineId(medicineId);
			cartBean.setMedicinePrice(price);
			cartBean.setMedicineName(medicineName);



			transaction.begin();
			entityManager.persist(cartBean);
			System.out.println("Medicine Added in your cart");
			transaction.commit();
			isadd=true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return isadd;
	}

	@Override
	public List<CartBean> showCart(int userId) {
		List<CartBean> info= null;
		EntityManager entityManager=null;
		try {
			entityManager=emf.createEntityManager();

			String jpql="from CartBean where userId =: userId";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			info=query.getResultList();
			entityManager.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		return info;
	}

	@Override
	public boolean deleteCart(int userId) {
		
		EntityManager entityManager = emf.createEntityManager();
		String jpql = "delete from CartBean where userId =: userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			 query.executeUpdate();
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
		
	}

	@Override
	public long bill(int userId) {

		long bill = 0;
		try {
			EntityManager entityManager = emf.createEntityManager();
			String jpql = "select sum(medicinePrice) from CartBean where userId =: userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			bill = (long) query.getSingleResult();
			return bill;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
