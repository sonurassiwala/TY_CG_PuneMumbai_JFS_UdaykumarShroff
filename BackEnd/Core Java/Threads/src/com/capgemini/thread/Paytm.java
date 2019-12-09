package com.capgemini.thread;

public class Paytm extends Thread{

	PVR ref;
	
	Paytm(PVR r)
	{
		ref = r;
	}
	
	public void run()
	{
		ref.confirm();
	}
	
}
