package com.capgemini.student;

import java.util.Comparator;

public class Byname implements Comparator<Student> {

	@Override
	public int compare(Student a1, Student a2) {

		return a1.getName().compareTo(a2.getName());
	
	}

}
