package com.capgemini.objectclass.methods;

public class TesrtH {

	public static void main(String[] args) {

		Product p = new Product();
		p.id = 1;
		p.name = "Pen";
		p.type = "Blue";
		p.cost = 24.23;
		p.brand = "Cello";
		
		Product p1 = new Product();
		p1.id = 2;
		p1.name = "Pencil";
		p1.type = "Black";
		p1.cost = 25.23;
		p1.brand = "Cello";
		
		Product p2 = new Product();
		p2.id = 1;
		p2.name = "Pen";
		p2.type = "Blue";
		p2.cost = 24.23;
		p2.brand = "Cello";
		
		boolean rsl = p.equals(p2);
		System.out.println(rsl);
		
	}

}
