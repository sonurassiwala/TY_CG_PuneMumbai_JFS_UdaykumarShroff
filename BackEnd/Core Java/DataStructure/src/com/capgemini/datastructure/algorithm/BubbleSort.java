package com.capgemini.datastructure.algorithm;

import java.time.Duration;
import java.time.Instant;

public class BubbleSort {

	
	 
	    void bubbleSort(int a[]) 
	    { 
	        int n = a.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (a[j] > a[j+1]) 
	                { 
	                    int temp = a[j]; 
	                    a[j] = a[j+1]; 
	                    a[j+1] = temp; 
	                } 
	    } 
	  
	    void printaay(int a[]) 
	    { 
	        int n = a.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(a[i] + " "); 
	        System.out.println(); 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        BubbleSort ob = new BubbleSort(); 
	        int a[] = {64, 34, 25, 12, 22, 11, 90,65,23,98,64,9,1,55,87,434,947,947,243,71,87,547,475}; 
	        Instant start = Instant.now();
	        ob.bubbleSort(a); 
	        Instant end = Instant.now();
	        System.out.println("Sorted array"); 
	        ob.printaay(a); 
	        
	        long duration = Duration.between(start, end).toMillis();
			double seconds = duration / 1000.0;
			System.out.println("Bubble sort time : " + seconds +" seconds");
	    } 
	} 
	
