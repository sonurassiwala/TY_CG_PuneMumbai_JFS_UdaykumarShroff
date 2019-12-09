package com.capgemini.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternConcepts {

	static Pattern pattern ;
	static Matcher matcher ;

	public static void main(String[] args) {
		
		pattern = Pattern.compile("\\d");	//for single digit 
		matcher = pattern.matcher("1");
		System.out.println("pattern \\d : "+matcher.matches());
		
		pattern = Pattern.compile("\\d+");	//more than 1 digit
		matcher = pattern.matcher("1145789630");
		System.out.println("pattern for more than 1 digit \\d+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\d{0}");	//{} -> for size of input
		matcher = pattern.matcher("");
		System.out.println("pattern for specified digits \\d+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\d{1,9}");	//for range pattern that given
		matcher = pattern.matcher("123456789");
		System.out.println("pattern  for range given \\d+ : "+matcher.matches());
		
		
		pattern = Pattern.compile("\\D");	//other than digit
		matcher = pattern.matcher("_");
		System.out.println("pattern for single \\D : "+matcher.matches());
		
		pattern = Pattern.compile("\\D+");
		matcher = pattern.matcher("ABCDEFG");
		System.out.println("pattern \\D+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\D{0}");	//{} -> for size of input
		matcher = pattern.matcher("");
		System.out.println("pattern for specified other than digits \\d+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\D{1,9}");	//for range pattern that given
		matcher = pattern.matcher("tfhgfl");
		System.out.println("pattern  for range given \\d+ : "+matcher.matches());

		pattern = Pattern.compile("\\w");	//only alphabets
		matcher = pattern.matcher("a");
		System.out.println("pattern \\w : "+matcher.matches());
		
		pattern = Pattern.compile("\\w+");
		matcher = pattern.matcher("ABCDEFG");
		System.out.println("pattern \\w+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\W");		//only single special character
		matcher = pattern.matcher("&");
		System.out.println("pattern \\W : "+matcher.matches());
	
		pattern = Pattern.compile("\\W+");		//only special characters
		matcher = pattern.matcher("@#$%^");
		System.out.println("pattern \\W+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\s");		//only single space
		matcher = pattern.matcher(" ");
		System.out.println("pattern space \\s : "+matcher.matches());
		
		pattern = Pattern.compile("\\s+");		//only special characters
		matcher = pattern.matcher("   ");
		System.out.println("pattern for multiple spaces \\s+ : "+matcher.matches());
		
		pattern = Pattern.compile("\\S");		//for no space
		matcher = pattern.matcher(" ");
		System.out.println("pattern for no spaces \\s+ : "+matcher.matches());
	}
}

