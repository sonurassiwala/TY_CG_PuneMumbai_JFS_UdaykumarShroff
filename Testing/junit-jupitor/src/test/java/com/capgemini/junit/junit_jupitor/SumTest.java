package com.capgemini.junit.junit_jupitor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumTest {

	@Test
	public void testAdd() {
		Sum s = new Sum();
		int i = s.add(10, 5);
		assertEquals(15, i);
	}

	@Test
	public void testAddforThree() {
		Sum s = new Sum();
		int j = s.add(10, 20, 30);
		assertEquals(60, j);
	}
	
	@Test
	public void testAddforegative() {
		Sum s = new Sum();
		int i = s.add(-10, 5);
		assertEquals(-5, i);
	}
	
}
