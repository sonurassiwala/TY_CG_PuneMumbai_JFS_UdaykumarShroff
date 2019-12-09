package com.capgemini.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestE {

	public static void main(String[] args) {

		LinkedHashMap<String, ArrayList<Student>> hm = new LinkedHashMap<String, ArrayList<Student>>();
		
		Student s1 = new Student("Amit", 1, 78.32);
		Student s2 = new Student("Suraj", 2, 88.32);
		Student s3 = new Student("Rushi", 3, 68.32);
		Student s4 = new Student("Niru", 4, 77.32);
		Student s5 = new Student("Samya", 5, 75.32);
		Student s6 = new Student("Sachya", 6, 56.32);
		Student s7 = new Student("Siddhya", 7, 80.32);
		Student s8 = new Student("Anil", 8, 70.32);
		Student s9 = new Student("Sunya", 9, 71.32);
		
		
		ArrayList<Student> al1 = new ArrayList<Student>();
		ArrayList<Student> al2 = new ArrayList<Student>();
		ArrayList<Student> al3 = new ArrayList<Student>();
		
		al1.add(s1);
		al1.add(s2);
		al1.add(s3);
		al2.add(s4);
		al2.add(s5);
		al3.add(s6);
		al3.add(s7);
		al3.add(s8);
		al3.add(s9);
		
		hm.put("First", al1);
		hm.put("Second", al1);
		hm.put("Third", al3);
		
		ArrayList<Student> al = hm.get("First");
		Iterator<Student> it = al.iterator();
		while(it.hasNext()) {
			Student s = it.next();
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage :"+s.percentage);
			System.out.println("----------------------------");
		}
		
		
	}

}
