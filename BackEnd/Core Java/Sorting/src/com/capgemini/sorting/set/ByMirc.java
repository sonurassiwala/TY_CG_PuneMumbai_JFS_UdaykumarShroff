package com.capgemini.sorting.set;

import java.util.Comparator;

public class ByMirc implements Comparator<Bank> {

	@Override
	public int compare(Bank a1, Bank a2) {
		Long k = a1.micr;
		Long t = a2.micr;
		
		return k.compareTo(t);
	}

}
