package com.capg.corejava.inheritance;

public class Driver {

	public void pass(Car i) {
	i.confirm();
	}
	public static void main(String[] args){
		Car c = new Car();
		Driver d = new Driver();
		d.pass(c);

	}
	

}
