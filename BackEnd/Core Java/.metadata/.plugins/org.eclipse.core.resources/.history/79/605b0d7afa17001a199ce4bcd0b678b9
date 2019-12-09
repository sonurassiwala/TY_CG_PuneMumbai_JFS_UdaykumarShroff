package com.capgemini.datastructure.algorithm;

import java.time.Duration;
import java.time.Instant;

public class BinarySearch {

	int binarySearch(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			if (arr[mid] == x)
				return mid;

			if (arr[mid] > x)
				return binarySearch(arr, l, mid - 1, x);

			return binarySearch(arr, mid + 1, r, x);
		}

		return -1;
	}

	public static void main(String args[]) {
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		Instant start = Instant.now();
		int result = ob.binarySearch(arr, 0, n - 1, x);
		Instant end = Instant.now();
		long duration = Duration.between(start, end).toMillis();
		double seconds = duration / 1000.0;
		System.out.println("Binary Search time : " + seconds +" seconds");
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at index " + result);
	}
}
