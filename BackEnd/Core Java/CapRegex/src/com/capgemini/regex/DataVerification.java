package com.capgemini.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataVerification {

	Pattern pat = null;
	Matcher mat = null;

	public boolean idVer(CharSequence userid) {

		pat = Pattern.compile("\\d+");
		mat = pat.matcher(userid);
		if(mat.matches()) {
			System.out.println("ID is true");
			return true;
		}
		return false;
	}

	public boolean nameVer(String name) {

		pat = Pattern.compile("\\w+\\s\\w+");
		mat = pat.matcher(name);
		if(mat.matches()) {
			System.out.println("Name is true");
			return true;
		}
		return false;
	}

	public boolean emailVer(String email) {

		pat = Pattern.compile("\\w+\\W\\w+\\.\\w+");
		mat = pat.matcher(email);
		if(mat.matches()) {
			System.out.println("Email is true");
			return true;
		}
		return false;
	}

	public boolean passVer(String pass) {

		pat = Pattern.compile("\\w+");
		mat = pat.matcher(pass);
		if(mat.matches()) {
			System.out.println("Password is true");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		DataVerification dv = new DataVerification();
		dv.emailVer("asd@adw.com");
		dv.nameVer("ASDD ksdk");
		dv.passVer("asdfghj");
		dv.idVer("2132345");
		
	}

}


