package com.capg.corejava.interfaces;

import java.io.Serializable;

@FunctionalInterface 		//it should have only one abstract method 
public interface InterfaceExample1 extends Serializable {

	
	 public void print(); 
	// public void printNum();
	 
	default void display() {	//only in interface outside interface doesn't work
		System.out.println("Default Method of Interface");
	}
	
	// it is not necessary 
	public static void show() {
		System.out.println("Static Method of Interface");
	}
	
}
