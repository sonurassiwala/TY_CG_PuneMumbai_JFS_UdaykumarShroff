package com.capgemini.collectionframework.display;

import java.util.ArrayList;

public class TestA {
	
public static void main(String[] args) 
	{
	

	
	ArrayList<Student> al = new ArrayList<Student>();
	
	Student s1 = new Student(1, "Amya", 89.32);
	Student s2 = new Student(2, "Surya", 74.22);
	Student s3 = new Student(3, "Rushi", 23.23);
	Student s4 = new Student(4, "Niru", 35.23);
	Student s5 = new Student(5, "Samya", 33.23);
	
	al.add(s1);
	al.add(s2);
	al.add(s3);
	al.add(s4);
	al.add(s5);
	
	Helper h = new Helper();
	h.display(al);
	System.out.println("*****Only Pass*********");
	h.onlyPass(al);
	System.out.println("*********Distinction************");
	h.distinction(al);
	
	}
}