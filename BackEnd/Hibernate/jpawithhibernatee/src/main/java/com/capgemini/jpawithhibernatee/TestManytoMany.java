package com.capgemini.jpawithhibernatee;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatee.manytomany.Course;
import com.capgemini.jpawithhibernatee.manytomany.Student;

public class TestManytoMany {

	public static void main(String[] args) {

		Course course = new Course();
		course.setCid(611);
		course.setCname("1JavScript-2");
		
		
		Course course1 = new Course();
		course1.setCid(512);
		course1.setCname("1HTML5");
		
		ArrayList<Course> ac = new ArrayList<Course>();
		ac.add(course);
		ac.add(course1);
		
		Student s1 = new Student();
		s1.setSid(10511);
		s1.setSname("Anil1");
		s1.setCourse(ac);
		
		Student s2 = new Student();
		s2.setSid(10612);
		s2.setSname("Siraj1");
		s2.setCourse(ac);
		
		ArrayList<Student> as = new ArrayList<Student>();
		as.add(s1);
		as.add(s2);
		
		course.setStudent(as);
		course1.setStudent(as);
		
		EntityManagerFactory entitymanagerfactory = null;
		EntityManager entitymanager = null; 
		EntityTransaction entitytransaction = null;
		
		try {
		entitymanagerfactory = Persistence.createEntityManagerFactory("test");
		entitymanager = entitymanagerfactory.createEntityManager();
		entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Course course2 = entitymanager.find(Course.class, 6);
		course2.getStudent().get(0).getSid();
		
		entitytransaction.commit();
		}
		catch (Exception e) {
		e.printStackTrace();
		entitytransaction.rollback();
		}
		entitymanager.close();
	}

}
