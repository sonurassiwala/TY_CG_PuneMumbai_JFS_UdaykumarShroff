package com.capgemini.medicalspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.medicalspringboot.bean.MedicineBean;

@Repository
public class MedicineDAOImpl implements MedicineDAO {
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public MedicineBean getMedicine(int medicineId) {
		EntityManager entityManager = emf.createEntityManager();
		MedicineBean medicineBean = entityManager.find(MedicineBean.class, medicineId);
		entityManager.close();

		return medicineBean;
	}

	@Override
	public boolean addMedicine(MedicineBean medicineBean) {

		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(medicineBean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteMedicine(int medicineId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			MedicineBean medicineBean= entityManager.find(MedicineBean.class, medicineId);
			entityManager.remove(medicineBean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}

	@Override
	public boolean updateMedicine(MedicineBean medicineBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isUpdated = false;
		MedicineBean medicineBean2 = manager.find(MedicineBean.class, medicineBean.getMedicineId());
		if(medicineBean2 != null) {
			
			if(medicineBean.getPrice() != 0) {
				medicineBean2.setPrice(medicineBean.getPrice());
			}
			
			if(medicineBean.getMedicineName() != null) {
				medicineBean2.setMedicineName(medicineBean.getMedicineName());
			}

			try {
				tx.begin();
				manager.persist(medicineBean2);
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
	public List<MedicineBean> getAllMedicine() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from MedicineBean";
		Query query = manager.createQuery(jpql);
		
		List<MedicineBean> medicineList = null;
		try {
			medicineList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicineList;
	}

}
