package com.capgemini.array.genric;

public class TestF {

	public static void main(String[] args) {

		Student[] s = new Student[4];
		
		Student st1 = new Student(1, "Amit", 98.12);
		Student st2 = new Student(2, "Suraj", 78.89);
		Student st3 = new Student(3, "Rushi", 74.42);
		Student st4 = new Student(4, "Niru", 85.52);
		
		s[0] = st1;
		s[1] = st2;
		s[2] = st3;
		s[3] = st4;
		
		receive(s);
		
	}

	static void receive(Student[] ar) {
		
		for( Student k : ar) {
			
			System.out.print(" "+k.id);
			System.out.print(" "+k.name);
			System.out.println(" "+k.percentage);
			System.out.println("****************************");
			
		}
		
	}
}
