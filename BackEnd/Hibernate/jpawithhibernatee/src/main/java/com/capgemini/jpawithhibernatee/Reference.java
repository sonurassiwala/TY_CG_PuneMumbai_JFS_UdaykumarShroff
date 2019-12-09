package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.dto.Movie;

public class Reference {

	public static void main(String[] args) {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Movie movie = entityManager.getReference(Movie.class, 2);	//entitynotfoundexception where there is not pk 
		
		System.out.println("Id : "+movie.getId());
		System.out.println("Name : "+movie.getMname());
		System.out.println("Rating : "+movie.getRating());
		
		
	
	}
	
}


//with reference entitynotfoundexception
//with find nullpointerexception