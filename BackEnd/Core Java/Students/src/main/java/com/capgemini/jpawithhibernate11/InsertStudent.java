package com.capgemini.jpawithhibernate11;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate1.dto.Student;

public class InsertStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		Student student = new Student();
		student.setId(125);
		student.setName("Rushi");
		student.setPercentage(87.72);

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(student);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		entityManager.close();

	}
	
}
