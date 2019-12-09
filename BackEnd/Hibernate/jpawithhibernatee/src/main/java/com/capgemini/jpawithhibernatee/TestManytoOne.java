package com.capgemini.jpawithhibernatee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.manyotone.Pencil;
import com.capgemini.jpawithhibernatee.manyotone.PencilBox;

public class TestManytoOne {

	public static void main(String[] args) {

		PencilBox pencilbox = new PencilBox();
		pencilbox.setBoxid(5);
		pencilbox.setName("Natraj");
		
		Pencil pencil1 = new Pencil();
		pencil1.setPid(7);
		pencil1.setColor("violet");
		pencil1.setPencilbox(pencilbox);
		
		Pencil pencil2 = new Pencil();
		pencil2.setPid(8);
		pencil2.setColor("orange");
		pencil2.setPencilbox(pencilbox);
		
		Pencil pencil3 = new Pencil();
		pencil3.setPid(9);
		pencil3.setColor("green");
		pencil3.setPencilbox(pencilbox);
		
		EntityManagerFactory entitymanagerfactory = null;
		EntityManager entitymanager = null; 
		EntityTransaction entitytransaction = null;
		
		try {
		entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		entitymanager = entitymanagerfactory.createEntityManager();
		entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		entitymanager.persist(pencil1);
		entitymanager.persist(pencil2);
		entitymanager.persist(pencil3);
		entitytransaction.commit();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		entitymanager.close();
		
	}

}
