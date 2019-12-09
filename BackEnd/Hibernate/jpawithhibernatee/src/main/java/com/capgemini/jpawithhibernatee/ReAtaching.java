package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.dto.Movie;

public class ReAtaching 
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
			Movie movie = entityManager.find(Movie.class, 2);
			System.out.println(movie.getId());
			System.out.println("Before : "+entityManager.contains(movie));
			entityManager.detach(movie);
			entityManager.clear();
			System.out.println("After : "+entityManager.contains(movie));
			Movie movie1 = entityManager.merge(movie);
			movie1.setMname("Race Gurram");
			
			System.out.println(entityManager.contains(movie));
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
