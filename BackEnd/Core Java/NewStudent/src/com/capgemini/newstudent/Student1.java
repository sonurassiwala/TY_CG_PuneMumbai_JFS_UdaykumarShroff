package com.capgemini.newstudent;

import java.util.function.Predicate;

public class Student1 {

	public static void main(String[] args) {

		int id = 1;
		String name = "Amit";
		double percentage = 77.23;
		
		
		// Predicate<Integer> p = i -> i%2 == 0;
		
		Predicate<Student1> p = i ->{
			
			if(percentage > 35) {
				return true;
			}
			else {
				return false;
			}
			
		};
		
		Student1 s = new Student1();
		
		boolean res = p.test(s);
		System.out.println("Result is : "+res);
		
	}
	
	
}
