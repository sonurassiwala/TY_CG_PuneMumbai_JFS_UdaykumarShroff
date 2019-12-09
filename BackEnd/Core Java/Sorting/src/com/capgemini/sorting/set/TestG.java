package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestG {

	public static void main(String[] args) {

		LinkedHashSet<Employee> e = new LinkedHashSet<Employee>();
		
		Employee e1 = new Employee(101, "Anil", 3000);
		Employee e2 = new Employee(102, "Suraj", 3500);
		Employee e3 = new Employee(103, "Rushi", 4000);
		Employee e4 = new Employee(104, "Niru", 4500);
		Employee e5 = new Employee(105, "Samya", 5000);
		
		e.add(e1);
		e.add(e2);
		e.add(e3);
		e.add(e4);
		e.add(e5);
		
		for(Employee f : e) {
			System.out.println(f.id);
			System.out.println(f.name);
			System.out.println(f.salary);
			System.out.println("************************");
		}
		
		System.out.println("**********iterator*******************");
		Iterator<Employee> it = e.iterator();
		while(it.hasNext()) {
			Employee r = it.next();
			System.out.println(r.id);
			System.out.println(r.name);
			System.out.println(r.salary);
			System.out.println("*******************");
		}
		
		
	}

}
