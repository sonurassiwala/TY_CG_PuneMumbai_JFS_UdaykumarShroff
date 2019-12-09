package com.capg.corejava.inheritance;

public class Father extends GrandFather {

	String fname = "Eddard";
	
	public static void main(String[] args) {
	
		/*
		   Father f = new Father(); 
		   f.printName();
		 */
		new Father().printName();
		
	}
	
	//@Override
	public void printName() {
		System.out.println(fname+ " "+name+" "+lastname);
		super.printName();
	}
	/*
	  public int printName1() { 	if there is other return type we have to give other method name
		System.out.println(fname+ " "+name+" "+lastname);
		super.printName();
		return ;
	}

	 * */

}
