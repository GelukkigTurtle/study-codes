package com.codechallenge;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given n ropes of different lengths, you need to connect these ropes into one rope. You can connect only 2 ropes at a time. 
 * The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths. 
 * This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.

		Input
		ropes, an int arrary representing the rope length.
		
		Output
		Return the min possible cost required to connect all ropes.
		
		Examples 1
		Input:
		ropes = [8, 4, 6, 12]
		
		Output:
		58
		
		Explaination:
		Explanation: The optimal way to connect ropes is as follows
		1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
		2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
		3. Connect the ropes of length 18 and 12 (cost is 30).
		Total cost to connect the ropes is 10 + 18 + 30 = 58
		
		Examples 2
		Input:
		ropes = [20, 4, 8, 2]
		
		Output:
		54
		
		Examples 3
		Input:
		ropes = [1, 2, 5, 10, 35, 89]
		
		Output:
		224
		
		Examples 4
		Input:
		ropes = [2, 2, 3, 3]
		
		Output:
		20
 * @author freddy
 *
 */
public class MinCostConnectRopes {

	public static void main(String[] args) {
		int[] files1 = {8, 4, 6, 12};
		int[] files2 = {20, 4, 8, 2};
		int[] files3 = {1, 2, 5, 10, 35, 89};
		int[] files4 = {2, 2, 3, 3};
		System.out.println(mergeFiles(files1));
		System.out.println(mergeFiles(files2));
		System.out.println(mergeFiles(files3));
		System.out.println(mergeFiles(files4));
	}

	private static int mergeFiles(int[] files) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int f : files) {
			minHeap.offer(f);
		}
		int res = 0;
		while(minHeap.size() > 1) {
			int f1 = minHeap.poll();
			int f2 = minHeap.poll();
			int tmp = f1 + f2;
			res += tmp;
			minHeap.offer(tmp);
		}
		return res;
	}

}
