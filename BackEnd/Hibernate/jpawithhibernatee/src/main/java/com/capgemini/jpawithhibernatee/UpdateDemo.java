package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.dto.Movie;

public class UpdateDemo 
{

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
			Movie movie = entityManager.find(Movie.class, 1);
			movie.setMname("kkhh");
			System.out.println("Record Update");
			transaction.commit();
		} catch (Exception e) 
		{
			transaction.rollback();
			e.printStackTrace();
		}
		entityManager.close();
	}

}

