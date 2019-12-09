package com.capgemini.jpawithhibernate1.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateStudent {

	public static void main(String[] args) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		
		entitytransaction.begin();
		Query query = entitymanager.createQuery("update Student set name = 'Suraj' where id = 124");
		int result = query.executeUpdate();
		System.out.println(result);
		if(result > 0) {
			System.out.println("Updated...");
		}
		else {
			System.out.println("Sorry....");
		}
		
		entitytransaction.commit();
	}
	
}
