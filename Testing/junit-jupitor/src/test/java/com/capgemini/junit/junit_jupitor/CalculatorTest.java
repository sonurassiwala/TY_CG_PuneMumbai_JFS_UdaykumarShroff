package com.capgemini.junit.junit_jupitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator calculator = null;

	@BeforeEach
	public void createObject() {
		calculator = new Calculator();
	}

	@Test
	public void addTest() {

		int i = calculator.add(10, 20);
		assertEquals(30, i);
	}

	@Test
	public void subTest() {
		int s = calculator.sub(50, 10);
		assertEquals(40, s);
	}

	@Test
	public void mulTest() {
		int m = calculator.mul(5, 4);
		assertEquals(20, m);
	}

	@Test
	public void divTest() {
		int d = calculator.div(60, 3);
		assertEquals(20, d);
	}

	@Test
	public void divTestByZero() {

		assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
	}

}
