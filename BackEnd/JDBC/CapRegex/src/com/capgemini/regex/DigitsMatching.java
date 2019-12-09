package com.capgemini.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitsMatching {

	public static void main(String[] args) {

		Pattern pat = Pattern.compile("\\W\\d{2}\\W\\d{10}"); // for phone numbers
		Matcher mat = pat.matcher("+91-9800000000");
		System.out.println("\\W\\d{2}\\W\\d{10} : "+mat.matches());
		
		pat = Pattern.compile("\\d{1,2}\\W\\w{3}\\W\\d{2,4}");
		mat = pat.matcher("01-Jan-96"); // for date of birth or hire dates
		System.out.println("\\d{1,2}\\W\\w{3}\\W\\d{2,4} : "+mat.matches());
		
	}

}
