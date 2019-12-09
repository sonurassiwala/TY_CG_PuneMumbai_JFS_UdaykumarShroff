package com.capgemini.exception.first;

import java.io.File;
import java.io.IOException;

public class TestE {

	public static void main(String[] args) {

		System.out.println("Main Started");
		
		File f = new File("G:/Uday.txt");
		
		try {
			f.createNewFile();
			System.out.println("File created");
		} 
		catch (IOException e) {
			System.out.println("Sry not able to create file");
		}
		
		System.out.println("Main Ended");
		
	}

}
