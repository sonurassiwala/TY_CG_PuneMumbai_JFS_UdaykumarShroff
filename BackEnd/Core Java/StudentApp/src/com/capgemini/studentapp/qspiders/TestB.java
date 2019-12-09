package com.capgemini.studentapp.qspiders;

import com.capgemini.studentapp.jspiders.*;

public class TestB {

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
