package com.capgemini.sorting.set;

import java.util.Comparator;

public class ByName implements Comparator<Bank> {

	@Override
	public int compare(Bank a1, Bank a2) {
		
		return a1.name.compareTo(a2.name);
		
	}

}
