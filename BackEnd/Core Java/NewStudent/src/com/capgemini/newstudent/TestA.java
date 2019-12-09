package com.capgemini.newstudent;

import java.util.ArrayList;

public class TestA {

	public static void main(String[] args) {

		ArrayList<Student> al = new ArrayList<Student>();
		
		Student s1 = new Student(1, "Amit", 'M', 77.21);
		Student s2 = new Student(2, "Suraj", 'M', 72.21);
		Student s3 = new Student(3, "Rushi", 'M', 78.21);
		Student s4 = new Student(4, "Niru", 'M', 28.21);
		Student s5 = new Student(5, "Aditi", 'F', 70.21);
		Student s6 = new Student(6, "Shruti", 'F', 67.21);
		Student s7 = new Student(7, "Disha", 'F', 27.21);
		Student s8 = new Student(8, "Sona", 'F', 32.21);
		
		al.add(s1);
		al.add(s2);
		al.add(s3);
		al.add(s4);
		al.add(s5);
		al.add(s6);
		al.add(s7);
		al.add(s8);
		
		Helper h = new Helper();
		h.minMarks(al);
	}

}
