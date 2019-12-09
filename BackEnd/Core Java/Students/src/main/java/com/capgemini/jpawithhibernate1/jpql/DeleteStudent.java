package com.capgemini.jpawithhibernate1.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteStudent {

	public static void main(String[] args) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Query query = entitymanager.createQuery("delete from Student where id = 125");
		int result = query.executeUpdate();
		if(result > 0) {
			System.out.println("Deleted...");
		}
		else {
			System.out.println("Sorry....");
		}
		entitytransaction.commit();	
	}

	
}
