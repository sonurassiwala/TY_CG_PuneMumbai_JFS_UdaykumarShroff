package com.capgemini.newstudent;

import java.util.function.Supplier;

public class TestD {

	public static void main(String[] args) {

		Supplier<Student> a = () -> new Student();
		
		Student s = a.get();
		Student p = a.get();
		
		System.out.println(s);
		System.out.println(p);
		
	}

}
