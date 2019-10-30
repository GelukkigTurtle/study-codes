package com.codebasics.arrays;

import java.io.*;
import java.util.*;

public class Mergin2Packages {

	public static void main(String[] args) {
		Integer[] arr = { 4, 6, 10, 15, 16 };
		int lim = 80;
		//int[] result = getIndicesOfItemWeights(arr, lim);
		//System.out.println(Arrays.toString(result));
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));

	}

	static int[] getIndicesOfItemWeights(int[] arr, int limit) {
		// your code goes here
		// your code goes here

		// 1. sort the array : O(nlog(n))
		// 2. iterate the array
		// 3. make operations over the array
		// TimeComplexity:O(nlog(n)) --> O(n)
		// [4, 6, 10, 15, 16], 21
		// {4: 0, 6 : 1},
		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum == limit) {
				return new int[] { i, j };
			} else if (sum < limit) {
				i++;
			} else {
				j--;
			}
		}

		return new int[] { };

	}

}
