package com.capgemini.exception.custom;

public class Validator
{

	void verify(int age) 
	{
		
		if(age < 18) 
		{
			
			throw new InvalidAgeException("Don't come inside");
			
		}
		
	}
	
}
