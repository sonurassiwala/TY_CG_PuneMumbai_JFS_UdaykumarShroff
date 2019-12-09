package com.capgemini.sorting.set;

import java.util.Comparator;

public class ById implements Comparator<Bank> {

	@Override
	public int compare(Bank a1, Bank a2) {

		if(a1.pin > a2.pin) {
			return 1;
		}
		else if(a1.pin < a2.pin) {
			return -1;
		}
		else {
			return 0;
		}
		
	}

}
