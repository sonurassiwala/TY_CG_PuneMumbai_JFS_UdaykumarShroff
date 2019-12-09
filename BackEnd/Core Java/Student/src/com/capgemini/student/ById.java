package com.capgemini.student;

import java.util.Comparator;

public class ById implements Comparator<Student> {

	@Override
	public int compare(Student a1, Student a2) {

		if(a1.getId() > a2.getId()) {
			return 1;
		}
		else if(a1.getId() < a2.getId()) {
			return -1;
		}
		else {
			return 0;
		}
		
	}

	
	
	
}
