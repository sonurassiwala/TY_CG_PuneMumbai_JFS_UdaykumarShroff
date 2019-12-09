package com.capgemini.jpawithhibernate11;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate1.dto.Student;

public class ReAttachingStudent {

	
	public static void main(String[] args) 
	{
		
		EntityManagerFactory entityManagerFactory =null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try 
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Student student = entityManager.find(Student.class, 124);
			System.out.println(student.getId());
			System.out.println("Before : "+entityManager.contains(student));
			entityManager.detach(student);
			entityManager.clear();
			System.out.println("After : "+entityManager.contains(student));
			Student student1 = entityManager.merge(student);
			student1.setName("Bharat");
			
			System.out.println(entityManager.contains(student1));
			transaction.commit();
		} 
		catch (Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}
		entityManager.close();
	}
	
}
