package com.capgemini.medicalcollection.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {
	
	Pattern pattern = null;
	Matcher matcher = null;

	@Override
	public boolean idValidation(String id) {
		pattern = Pattern.compile("\\d{1,3}");
		matcher = pattern.matcher(id);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean nameValidation(String name) {
		pattern = Pattern.compile("\\D+");
		matcher = pattern.matcher(name);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean emailValidation(String email) {
		pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		matcher = pattern.matcher(email);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean passValidation(String password) {
		pattern = Pattern.compile("\\w{4,12}");
		matcher = pattern.matcher(password);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean cardValidation(String cardNo) {
		pattern = Pattern.compile("\\d{1,16}");
		matcher = pattern.matcher(cardNo);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean priceValidation(String price) {
		pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}");
		matcher = pattern.matcher(price);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

}
