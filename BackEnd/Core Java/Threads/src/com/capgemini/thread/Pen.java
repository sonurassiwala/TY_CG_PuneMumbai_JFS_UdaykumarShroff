package com.capgemini.thread;

public class Pen extends Thread{

	
	public void run() {
	
		for(int i =0; i<5; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
