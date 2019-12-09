package com.capgemini.strem;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;



public class TestA {

	public static void main(String[] args) {

		Comparator<Employee> c = (e1,e2) -> {
			
			if(e1.height > e2.height) {
				return 1;
			}
			else if(e1.height < e2.height) {
				return -1;
			}
			else {
				return 0;
			}
			
			
		};
		
		TreeSet<Employee> te = new TreeSet<Employee>(c);
		
		Employee e1 = new Employee(101, "Amit", 4.2);
		Employee e2 = new Employee(102, "Suraj", 5.6);
		Employee e3 = new Employee(103, "Rushi", 4.9);
		Employee e4 = new Employee(104, "Niru", 6.1);
		
		te.add(e1);
		te.add(e2);
		te.add(e3);
		te.add(e4);
		
		Iterator<Employee> it = te.iterator();
		while(it.hasNext()) {
			Employee r = it.next();
			System.out.println(r.id);
			System.out.println(r.name);
			System.out.println(r.height);
			System.out.println("*******************");
		
		}
	}

}
