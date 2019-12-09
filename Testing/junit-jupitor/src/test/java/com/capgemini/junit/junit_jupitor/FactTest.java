package com.capgemini.junit.junit_jupitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactTest {

	@Test
	public void testFactforNumbber() {
		Factorial f = new Factorial();
		int fc = f.fact(5);
		assertEquals(120, fc);
	}
	
	@Test
	public void testFactforZero() {
		Factorial f = new Factorial();
		int fc = f.fact(0);
		assertEquals(1, fc);
	}
	
	@Test
	public void testFactforNegative() {
		Factorial f = new Factorial();
		int fc = f.fact(-6);
		assertEquals(1, fc);
	}
	
}
