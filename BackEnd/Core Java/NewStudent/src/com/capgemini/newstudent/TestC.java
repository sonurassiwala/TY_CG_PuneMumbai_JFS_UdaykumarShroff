package com.capgemini.newstudent;

import java.util.function.Function;

public class TestC {

	public static void main(String[] args) {

		Function<Integer, Student> f = i -> {
			
			Student s = new Student();
			s.id = i;
			return s;
		};
		
		Student s = f.apply(10);
		System.out.println("Name : "+s.name);
		System.out.println("Id : "+s.id);
		System.out.println("Percentage : "+s.percentage);
		
	}

}
