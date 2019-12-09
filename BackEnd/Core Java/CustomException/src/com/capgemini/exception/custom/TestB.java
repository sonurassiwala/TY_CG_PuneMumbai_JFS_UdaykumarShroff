package com.capgemini.exception.custom;

public class TestB 
{

	public static void main(String[] args) 
	{

		AmountCheck amt = new AmountCheck();
		
		try 
		{
			amt.check(50000);
			System.out.println("Collect Cash");
		} 
		catch (InvalidLimitException e) 
		{
			System.err.println(e.getMessage());
			//e.printStackTrace();		//fully qualified path and msg
		}
		
	}

}
