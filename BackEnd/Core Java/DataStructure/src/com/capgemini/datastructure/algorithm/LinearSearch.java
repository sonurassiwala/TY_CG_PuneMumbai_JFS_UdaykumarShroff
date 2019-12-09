package com.capgemini.datastructure.algorithm;

import java.time.Duration;
import java.time.Instant;

public class LinearSearch {


	public static int search(int arr[], int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 10;

		Instant start = Instant.now();
		int result = search(arr, x);
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("Linear Search time : " + seconds +" seconds");
		if (result == -1)
			System.out.print("Element is not present in array");
		else
			System.out.print("Element is present at index " + result);
	}
}
