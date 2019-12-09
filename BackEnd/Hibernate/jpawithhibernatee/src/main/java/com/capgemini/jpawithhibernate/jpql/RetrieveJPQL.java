package com.capgemini.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpawithhibernatee.dto.Movie;

public class RetrieveJPQL {

	public static void main(String[] args) {

		String jpql = "from Movie";
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		Query query = entitymanager.createQuery(jpql);
		List<Movie> l = query.getResultList();
		for(Movie m : l) {
			System.out.println(m.getId());
			System.out.println(m.getMname());
			System.out.println(m.getRating());
			System.out.println("-------------------------");
		}

	}

}
