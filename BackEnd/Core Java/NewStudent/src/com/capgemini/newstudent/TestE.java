package com.capgemini.newstudent;

import java.util.function.Consumer;

public class TestE {

	public static void main(String[] args) {

		Consumer<Student> c = (s) -> {
			
			System.out.println("Name : "+s.name);
			System.out.println("Id : "+s.id);
			System.out.println("Percentage : "+s.percentage);
			
		};
		
		Student s1 = new Student(1, "Amit", 'M',77.23);
		c.accept(s1);
	}

}
