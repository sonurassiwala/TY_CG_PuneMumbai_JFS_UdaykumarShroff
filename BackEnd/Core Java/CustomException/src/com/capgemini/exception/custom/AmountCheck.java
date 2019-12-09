package com.capgemini.exception.custom;

public class AmountCheck 
{

	void check(int val) throws InvalidLimitException
	{

		if(val > 40000) {

			throw new InvalidLimitException();
		}
	}


}
