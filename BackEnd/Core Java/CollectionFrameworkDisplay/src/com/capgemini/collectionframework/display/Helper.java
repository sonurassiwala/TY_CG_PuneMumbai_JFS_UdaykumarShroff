package com.capgemini.collectionframework.display;

import java.util.ArrayList;
import java.util.Iterator;


public class Helper {


	void display(ArrayList<Student> k) {

		for(Student s : k) {

			System.out.println(s.id);
			System.out.println(s.name);
			System.out.println(s.percentage);
			System.out.println("----------------------------");

		}

	}

	void onlyPass(ArrayList<Student> l) {

		Iterator<Student> it = l.iterator();
		while(it.hasNext()) {


			Student r = it.next();
			if(r.percentage >= 35) {
				System.out.println(r.id);
				System.out.println(r.name);
				System.out.println(r.percentage);
			}
		}
	}
	
	void distinction(ArrayList<Student> d) {

		Iterator<Student> it = d.iterator();
		while(it.hasNext()) {
			
			Student r = it.next();
			if(r.percentage >= 75) {
				System.out.println(r.id);
				System.out.println(r.name);
				System.out.println(r.percentage);
			}
		}

	}

}
