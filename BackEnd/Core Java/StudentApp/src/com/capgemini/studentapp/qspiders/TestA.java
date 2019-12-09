package com.capgemini.studentapp.qspiders;

import com.capgemini.studentapp.jspiders.Angular;	
import com.capgemini.studentapp.jspiders.React;

public class TestA {

	public static void main(String[] args) {
		
		Selenium s = new Selenium();
		s.teachSelenium();
		
		QTP q = new QTP();
		q.teachQTP();
		
		React r = new React();
		r.teachReact();
		
		Angular a = new Angular();
		a.teachAngular();

	}

}
