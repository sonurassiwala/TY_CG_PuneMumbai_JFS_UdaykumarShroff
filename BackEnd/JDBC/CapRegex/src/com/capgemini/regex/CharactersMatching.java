package com.capgemini.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharactersMatching {

	public static void main(String[] args) {

		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+"); // for email id's.
		Matcher mat = pat.matcher("qwerty@email.com");
		System.out.println("\\w+\\@\\w+\\.\\w+ : "+mat.matches());
		
		pat = Pattern.compile("\\w+\\s\\w+\\s\\w+"); // for first, middle, and last name
		mat = pat.matcher("A B C");
		System.out.println("\\w+\\s\\w+\\s\\w+ : "+mat.matches());
		
		pat = Pattern.compile("[A-Za-z]{1,25}\\s[A-Za-z]{1,25}"); //for names with limited chars
		mat = pat.matcher("Ivan Shishkin");
		System.out.println("[A-Za-z]{1,25}\\s[A-Za-z]{1,25} : "+mat.matches());
		
		pat = Pattern.compile("\\w+\\W+\\w+"); //for alphanumeric passwords
		mat = pat.matcher("afimf#4df");
		System.out.println("\\w+\\W+\\w+ : "+mat.matches());
		
	}

}
