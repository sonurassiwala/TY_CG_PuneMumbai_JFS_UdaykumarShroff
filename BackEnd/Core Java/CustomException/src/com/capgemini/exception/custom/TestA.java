package com.capgemini.exception.custom;

public class TestA
{

	public static void main(String[] args) 
	{

		Validator v = new Validator();
		
		try {
		v.verify(15);
		System.out.println("Welcome to PUB");
		}
		catch(InvalidAgeException e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}

}
