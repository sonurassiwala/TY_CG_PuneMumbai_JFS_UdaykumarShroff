package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.onetoone.Person;
import com.capgemini.jpawithhibernate.onetoone.VoterCard;

public class OneToOne 
{

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		VoterCard votercard = new VoterCard();
		Person person = new Person();
		person.setPid(3);
		person.setName("Suresh");
		person.setVotercard(votercard);
		
		
		votercard.setVid(103);
		votercard.setAddress("Indore");

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			//entityManager.persist(person);
			
			  VoterCard cardDetail = entityManager.find(VoterCard.class, 103);
			  cardDetail.getVid(); cardDetail.getAddress();
			  System.out.println(cardDetail.getPerson().getPid());
			  System.out.println(cardDetail.getPerson().getName());
			  
			  System.out.println("Record Saved");
			 
			 
			
			
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		entityManager.close();

	}

	
}
