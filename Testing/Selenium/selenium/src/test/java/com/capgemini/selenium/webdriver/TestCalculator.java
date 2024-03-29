package com.capgemini.selenium.webdriver;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

	Calculator cal = new Calculator();
	
	@Test
	public void addTest() {
		
		int a = 10;
		int b = 20;
		int expected = 30;
		int actual = cal.add(a, b);
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void subTest() {
		
		int a = 40;
		int b = 20;
		int expected = 20;
		int actual = cal.sub(a,b);
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void mulTest() {
		
		int a = 40;
		int b = 20;
		int expected = 800;
		int actual = cal.mul(a,b);
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void divTest() {
		
		int a = 40;
		int b = 20;
		int expected = 2;
		int actual = cal.div(a,b);
		
		Assert.assertEquals(expected, actual);
		
	}
	
}
