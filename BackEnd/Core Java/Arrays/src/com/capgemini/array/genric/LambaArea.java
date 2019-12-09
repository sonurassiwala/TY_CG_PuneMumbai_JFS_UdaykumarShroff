package com.capgemini.array.genric;

interface Area{
	
	double area(double r);
	
}

public class LambaArea {

	public static void main(String[] args) {
		
		Area a = r -> 3.142*r*r;
		double d = a.area(5.2);
		System.out.println("Area is : "+d);

	}

}
