package com.capgemini.student;

import java.util.TreeSet;

public class TestA {

	public static void main(String[] args) {

		ById bi = new ById();
		Byname bn = new Byname();
		ByPercentage bp = new ByPercentage();
		
		
		TreeSet<Student> ts = new TreeSet<Student>(bn);
		
		Student s1 = new Student();
		s1.setName("Anil");
		s1.setId(1);
		s1.setPercentage(45.23);
		s1.setGender('M');
		
		Student s2 = new Student();
		s2.setName("Suraj");
		s2.setId(2);
		s2.setPercentage(65.23);
		s2.setGender('M');
		
		Student s3 = new Student();
		s3.setName("Aditi");
		s3.setId(3);
		s3.setPercentage(75.23);
		s3.setGender('F');
		
		Student s4 = new Student();
		s4.setName("Sona");
		s4.setId(4);
		s4.setPercentage(55.23);
		s4.setGender('F');
		
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		
		for(Student s : ts) {
			
			System.out.println("Name is : "+s.getName());
			System.out.println("Id is : "+s.getId());
			System.out.println("Percentage is : "+s.getPercentage());
			System.out.println("Gender is : "+s.getGender());
			System.out.println("--------------------------------------");
		}
		
	}

}
