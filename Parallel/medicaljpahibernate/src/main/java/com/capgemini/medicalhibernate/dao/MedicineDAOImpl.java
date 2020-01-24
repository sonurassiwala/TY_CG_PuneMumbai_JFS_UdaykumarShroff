package com.capgemini.medicalhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.medicalhibernate.dto.MedicineBean;
import com.capgemini.medicalhibernate.dto.UserBean;
import com.capgemini.medicalhibernate.exception.MedicalException;

public class MedicineDAOImpl implements MedicneDAO {

	@Override
	public List<MedicineBean> getMedicine() {

		try {
			String jpql = "from MedicineBean";
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			Query query = entitymanager.createQuery(jpql);
			List<MedicineBean> ml = query.getResultList();
			System.out.println("----------Medicines----------");
			for (MedicineBean m : ml) {
				System.out.println("Medicine Code : " + m.getMedicineCode());
				System.out.println("Medicine Name : " + m.getMedicineName());
				System.out.println("Price : " + m.getPrice());
				System.out.println("Quantity : " + m.getQuantity());
				System.out.println("Category : " + m.getCategory());
				System.out.println("-------------------------------------------");
			}

			return ml;
		} catch (Exception e) {
			throw new MedicalException("No medicine found");
		}
	}

	@Override
	public boolean addMedicine(String name, int price, int quantity, String category) {

		try {
			MedicineBean mb = new MedicineBean();
			mb.setMedicineName(name);
			mb.setPrice(price);
			mb.setQuantity(quantity);
			mb.setCategory(category);
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(mb);
			System.out.println("Added Successfully....!!");
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new MedicalException("Unable to Add Medicine");
		}

		return true;
	}

	@Override
	public boolean changePrice(MedicineBean medicineBean) {
		
		try {
			int id = medicineBean.getMedicineCode();
			int prc = medicineBean.getPrice();
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			
			MedicineBean medicineBean2 = entitymanager.find(MedicineBean.class, medicineBean.getMedicineCode());
			if(medicineBean2 != null) {
				if(medicineBean.getPrice() != 0) {
					medicineBean2.setPrice(medicineBean.getPrice());
				}
			}
			
			entitymanager.persist(medicineBean2);
			entitytransaction.commit();
			
			
			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to Change Price");
		}
	}

	@Override
	public boolean removeMed(MedicineBean medicineBean) {
		
		try {
			EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
			EntityManager entitymanager = entitymanagerfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			
			medicineBean = entitymanager.find(MedicineBean.class, medicineBean.getMedicineCode());
			entitymanager.remove(medicineBean);
			entitytransaction.commit();
			
			return true;
		} catch (Exception e) {
			throw new MedicalException("Unable to remove Medicine");
		}
	}

}
