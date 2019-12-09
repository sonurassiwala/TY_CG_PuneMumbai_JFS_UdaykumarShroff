package com.capgemini.thread;

public class Test {

	public static void main(String[] args) {

		System.out.println("Main start");
		

		Pen p = new Pen();
		p.start();
		
		Pen t = new Pen();
		t.start();
		try {
			p.join();
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Ended");
	}

}
