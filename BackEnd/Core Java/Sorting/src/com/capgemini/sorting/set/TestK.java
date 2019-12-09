package com.capgemini.sorting.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TestK {

	public static void main(String[] args) {

		ByMirc c = new ByMirc();
		
		TreeSet<Bank> tb = new TreeSet<Bank>(c);
		
		Bank b1 = new Bank(1111, "SBI", 1236547890);
		Bank b2 = new Bank(2222, "BOM", 1410258963);
		Bank b3 = new Bank(3333, "BOI", 45693210);
		Bank b4 = new Bank(4444, "ICICI", 154678930);
		
		tb.add(b1);
		tb.add(b2);
		tb.add(b3);
		tb.add(b4);
		
		Iterator<Bank> it = tb.iterator();
		while(it.hasNext()) {
			Bank r = it.next();
			System.out.println(r.pin);
			System.out.println(r.name);
			System.out.println(r.micr);
			System.out.println("*******************");
		}
		
		
		
	}

}
