package com.capgemini.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateJPQL {

	public static void main(String[] args) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		
		entitytransaction.begin();
		Query query = entitymanager.createQuery("update Movie set mname = 'kkkg' where id = 1");
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
