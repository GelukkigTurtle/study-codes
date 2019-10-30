package com.codebasics.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinArray {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,7,4};
		int k = 2;
		int largest = findKthLargest(nums, k);
		int smallest = kthSmallest(nums, k);

		System.out.println(largest);
		System.out.println(smallest);
	}
	
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(k);
		for(int i: nums) {
			heap.offer(i);
			if(heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}
	
	public static int kthSmallest(int [] arr, int k)  { 
			// Sort the given array 
			Arrays.sort(arr); 
			
			// Return k'th element in  
			// the sorted array 
			return arr[k-1]; 
      }  

}
