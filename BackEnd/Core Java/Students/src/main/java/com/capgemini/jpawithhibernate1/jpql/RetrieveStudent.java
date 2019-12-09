package com.capgemini.jpawithhibernate1.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpawithhibernate1.dto.Student;


public class RetrieveStudent {

	public static void main(String[] args) {

		String jpql = "from Student";
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		Query query = entitymanager.createQuery(jpql);
		List<Student> l = query.getResultList();
		for(Student s : l) {
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getPercentage());
			System.out.println("-------------------------");
		}

	}

	
}
