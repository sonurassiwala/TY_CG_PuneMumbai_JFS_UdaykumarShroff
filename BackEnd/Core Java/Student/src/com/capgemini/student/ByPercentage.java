package com.capgemini.student;

import java.util.Comparator;

public class ByPercentage implements Comparator<Student>{

	@Override
	public int compare(Student a1, Student a2) {
		
		if(a1.getPercentage() > a2.getPercentage()) {
			return 1;
		}
		else if(a1.getPercentage() < a2.getPercentage()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
