package com.capgemini.thread;

public class PVR {

	synchronized void confirm() 	//synchronized use to complete one execution first and then go for other : threadsafe
	{
		for (int i = 0; i < 5; i++) 
		{
			System.out.println(i);
			
			try
			{
				wait();
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	synchronized void leaveMe() {
		System.out.println("Notify called");
		notify();
		
	}
	
}
//only methods can be threadsafe by using keyword synchronized