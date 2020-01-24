package com.capgemini.medicalcollection.validation;

public interface Validation {

	public boolean idValidation(String id);
	public boolean nameValidation(String name);
	public boolean emailValidation(String email);
	public boolean passValidation(String password);
	public boolean cardValidation(String cardNo);
	public boolean priceValidation(String price);
	
}
