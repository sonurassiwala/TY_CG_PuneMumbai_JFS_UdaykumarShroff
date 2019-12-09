package com.capgemini.thread;

public class TestA {

	public static void main(String[] args) 
	{

		PVR a = new PVR();
		
		Paytm t1 = new Paytm(a);
		Paytm t2 = new Paytm(a);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.leaveMe();
		
	}

}
