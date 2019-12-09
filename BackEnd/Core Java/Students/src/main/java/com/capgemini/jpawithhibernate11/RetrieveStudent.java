package com.capgemini.jpawithhibernate11;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate1.dto.Student;

public class RetrieveStudent {

public static void main(String[] args) {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student = entityManager.find(Student.class, 123);
		entityManager.persist(student);
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getPercentage());
		
		
	
	}
	
}
