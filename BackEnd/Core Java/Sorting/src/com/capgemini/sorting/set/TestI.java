package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.TreeSet;		//Treeset can implements only comparable type objects

public class TestI {

	public static void main(String[] args) {

		TreeSet<Employee> te = new TreeSet<Employee>();
		
		Employee e1 = new Employee(101, "Amit", 3000);
		Employee e2 = new Employee(102, "Suraj", 3500);
		Employee e3 = new Employee(103, "Rushi", 4000);
		Employee e4 = new Employee(104, "Niru", 4500);
		Employee e5 = new Employee(102, "Suraj", 3500);
		
		te.add(e1);
		te.add(e2);
		te.add(e3);
		te.add(e4);
		te.add(e5);
		
		System.out.println("**********iterator*******************");
		Iterator<Employee> it = te.iterator();
		while(it.hasNext()) {
			Employee r = it.next();
			System.out.println(r.id);
			System.out.println(r.name);
			System.out.println(r.salary);
			System.out.println("*******************");
		}
		
		
	}

}
