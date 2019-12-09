package com.capgemini.collectionframework.list;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestQ {

	public static void main(String[] args) {
		
		
LinkedList<Student> s = new LinkedList<Student>();
		
		Student s1 = new Student(1, "Amya", 89.32);
		Student s2 = new Student(2, "Surya", 79.22);
		
		s.add(s1);
		s.add(s2);
		
		for (int i = 0; i < 2; i++) {
			Student ss = s.get(i);
			System.out.println(ss.id);
			System.out.println(ss.name);
			System.out.println(ss.percentage);
			System.out.println("***********************");
			
		}
		
		for(Student st : s) {
			System.out.println(st.id);
			System.out.println(st.name);
			System.out.println(st.percentage);
			System.out.println("***********************");
		}
		
		System.out.println("**********iterator*******************");
		Iterator<Student> it = s.iterator();
		while(it.hasNext()) {
			Student r = it.next();
			System.out.println(r.id);
			System.out.println(r.name);
			System.out.println(r.percentage);
		}
		
		System.out.println("**********ListIterator*******************");
		System.out.println("**********Forward*******************");
		ListIterator<Student> lit = s.listIterator();
		while(lit.hasNext()) {
			Student t = lit.next();
			System.out.print(t.id+" ");
			System.out.print(t.name+" ");
			System.out.println(t.percentage+" ");
		}
		System.out.println("**********Backward*******************");
		while(lit.hasPrevious()) {
			Student y = lit.previous();
			System.out.print(y.id+" ");
			System.out.print(y.name+" ");
			System.out.println(y.percentage+" ");
		}
		
		
	}
	
}
