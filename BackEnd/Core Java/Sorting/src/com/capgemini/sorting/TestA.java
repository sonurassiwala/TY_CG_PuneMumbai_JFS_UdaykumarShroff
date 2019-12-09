package com.capgemini.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TestA {

	public static void main(String[] args) {

		ArrayList<Student> s = new ArrayList<Student>();
		
		Student s1 = new Student(1, "Priya", 65.4);
		Student s2 = new Student(5, "Anil", 42.3);
		Student s3 = new Student(3, "Dinesh", 51.6);
		Student s4 = new Student(2, "Raju", 76.8);
		
		s.add(s1);
		s.add(s2);
		s.add(s3);
		s.add(s4);
		
		Collections.sort(s);
		
		Iterator<Student> it = s.iterator();
		while(it.hasNext()) {
			
			Student a = it.next();
			
			System.out.println("Name is : "+a.name);
			System.out.println("Id : "+a.id);
			System.out.println("Percentage : "+a.percentage);
			System.out.println("------------------");
			
		}
		
		
	}

}
