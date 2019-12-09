	package com.capgemini.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springboot.bean.EmployeeInfoBean;


@Repository
public class EmployeeDAOjpaImpl implements EmployeeDAO {
	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public EmployeeInfoBean getEmployee(int empId) {

		EntityManager manager = emf.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		manager.close();

		return employeeInfoBean;

	}// End of getEmployee()

	@Override
	public EmployeeInfoBean authenticate(int empId, String pwd) {
		EntityManager manager = emf.createEntityManager();

//		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
//		manager.close();
//		if(employeeInfoBean != null && pwd.equals(employeeInfoBean.getPassword())){
//			return employeeInfoBean;
//		}else {
//		return null;
//		}

		String jpql = "from EmployeeInfoBean where empId =: empId and password =: pwd";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empId);
		query.setParameter("pwd", pwd);

		EmployeeInfoBean employeeInfoBean = null;

		try {
			employeeInfoBean = (EmployeeInfoBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeInfoBean;

	}// End of Authenticate

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(employeeInfoBean);
			tx.commit();
			isAdded = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		manager.close();//
		
		
		return isAdded;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isUpdated = false;
		EmployeeInfoBean employeeInfoBean2 = manager.find(EmployeeInfoBean.class, employeeInfoBean.getEmpId());
		if(employeeInfoBean2 != null) {
			if(employeeInfoBean.getEmpName() != null) {
				employeeInfoBean2.setEmpName(employeeInfoBean.getEmpName());
			}
			if(employeeInfoBean.getDesignation() != null) {
				employeeInfoBean2.setDesignation(employeeInfoBean.getDesignation());
			}
			if(employeeInfoBean.getPassword() != null) {
				employeeInfoBean2.setPassword(employeeInfoBean.getPassword());
			}
			if(employeeInfoBean.getAge() > 0) {
				employeeInfoBean2.setAge(employeeInfoBean.getAge());
			}
			if(employeeInfoBean.getSalary() > 0) {
				employeeInfoBean2.setSalary(employeeInfoBean.getSalary());
			}
			if(employeeInfoBean.getGender() != ' ') {
				employeeInfoBean2.setGender(employeeInfoBean.getGender());
			}
			if(employeeInfoBean.getMobile() != 0) {
				employeeInfoBean2.setMobile(employeeInfoBean.getMobile());
			}
			
		
		try {
			tx.begin();
			manager.persist(employeeInfoBean2);
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
	public boolean deleteEmployee(int empId) {
		EntityManager entityManager = emf.createEntityManager();
		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			EmployeeInfoBean employeeInfoBean= entityManager.find(EmployeeInfoBean.class, empId);
			entityManager.remove(employeeInfoBean);
			tx.commit();
			isDeleted = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		entityManager.close();
		return isDeleted;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = emf.createEntityManager();
		String jpql = "from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		
		List<EmployeeInfoBean> employeesList = null;
		try {
			employeesList = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeesList;
	}

}// End of class
