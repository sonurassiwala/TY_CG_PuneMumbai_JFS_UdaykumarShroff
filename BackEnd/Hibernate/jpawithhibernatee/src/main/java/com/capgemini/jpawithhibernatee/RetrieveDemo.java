package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.dto.Movie;

public class RetrieveDemo {

	public static void main(String[] args) {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Movie movie = entityManager.find(Movie.class, 1);
		entityManager.persist(movie);
		System.out.println("Id : "+movie.getId());
		System.out.println("Name : "+movie.getMname());
		System.out.println("Rating : "+movie.getRating());
		
		
	
	}// end of Main method
	
}
