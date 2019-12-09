package com.capgemini.sorting.set;

import java.util.HashSet;
import java.util.Iterator;

public class TestF {

	public static void main(String[] args) {
		
		
		HashSet<Employee> he = new HashSet<Employee>();
		
		Employee e1 = new Employee(101, "Amit", 3000);
		Employee e2 = new Employee(102, "Suraj", 3500);
		Employee e3 = new Employee(103, "Rushi", 4000);
		Employee e4 = new Employee(104, "Niru", 4500);
		Employee e5 = new Employee(102, "Suraj", 3500);
		
		he.add(e1);
		he.add(e2);
		he.add(e3);
		he.add(e4);
		he.add(e5);
		
		/*
		 * for(Employee f : he) { System.out.println(f.id); System.out.println(f.name);
		 * System.out.println(f.salary);
		 * System.out.println("************************8"); }
		 */
		
		System.out.println("**********iterator*******************");
		Iterator<Employee> it = he.iterator();
		while(it.hasNext()) {
			Employee r = it.next();
			System.out.println(r.id);
			System.out.println(r.name);
			System.out.println(r.salary);
			System.out.println("*******************");
		}
		
		
	}

}
