package com.codechallenge;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Give a computer with total K memory space, and an array of foreground tasks
 * and background tasks the computer need to do. Write an algorithm to find a
 * pair of tasks from each array to maximize the memory usage. Notice the tasks
 * could be done without origin order.
 * 
 * Input The input to the function/method consists of three arguments :
 * foregroundTask, an array representing the memory usage of the foreground
 * tasks, backgroundTask, an array representing the memory usage of the
 * background tasks, K, the total memory space of the computer.
 * 
 * Output Return a list of pairs of the task ids.
 * 
 * Examples 1 Input: foregroundTasks = [1, 7, 2, 4, 5, 6] backgroundTasks = [3,
 * 1, 2] K = 6
 * 
 * Output: [(3, 2), (4, 1)]
 * 
 * Explaination: Here we have 5 foreground tasks: task 0 uses 1 memeory. task 1
 * uses 7 memeory. task 2 uses 2 memeory.. And 5 background tasks: task 0 uses 3
 * memeory. task 1 uses 1 memeory. task 2 uses 2 memeory.. We need to find two
 * tasks with total memory usage sum <= K. So we find the foreground task 3 and
 * background task 2. Total memory usage is 6. And the foreground task 4 and
 * background task 1. Total memory usage is also 6.
 * 
 * Examples 2 Input: foregroundTasks = [1, 7, 2, 4, 5, 6] backgroundTasks = [3,
 * 1, 2] K = 10
 * 
 * Output: [(1, 2))]
 * 
 * Explaination: Here we find the foreground task 1 and background task 2. Total
 * memory usage is 7 + 2 = 9, which is < 10.
 * 
 * @author freddy
 *
 */
public class OptimizeMemoryUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int memory = 10;

        List<Integer>  foregroundtasks = new ArrayList<>();
        List<Integer> backgroundtaks = new ArrayList<>();
        
        foregroundtasks.add(1);
        foregroundtasks.add(7);
        foregroundtasks.add(2);
        foregroundtasks.add(4);
        foregroundtasks.add(5);
        foregroundtasks.add(6);
        
        backgroundtaks.add(3);
        backgroundtaks.add(1);
        backgroundtaks.add(2);
        
        List<List<Integer>> result = twoSumClosest2Target(memory, foregroundtasks, backgroundtaks);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("[" + result.get(i).get(0) + "," + result.get(i).get(1) + "]");
        }


	}

	public static List<List<Integer>> twoSumClosest2Target(int maxTravelDist, List<Integer> forwardRouteList,
			List<Integer> retumRouteList) {
		// CORNER CASE
		if (forwardRouteList == null || forwardRouteList.size() == 0 || retumRouteList == null
				|| retumRouteList.size() == 0) {
			return new ArrayList<>();
		}

		int sum;
		int minSum = Integer.MIN_VALUE;
		List<List<Integer>> result = new ArrayList<>();

		// find each possible pair
		for (int i = 0; i < forwardRouteList.size(); i++) {
			for (int j = 0; j < retumRouteList.size(); j++) {
				sum = forwardRouteList.get(i) + retumRouteList.get(j);
				if (Math.abs(sum - maxTravelDist) < Math.abs(minSum - maxTravelDist)) {
					minSum = sum;
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);

					// clear() not remove() due to not ensuring result size
					result.clear();
					result.add(list);
				} else if (Math.abs(sum - maxTravelDist) == Math.abs(minSum - maxTravelDist)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					result.add(list);
				}
			}
		}
		return result;
	}

}
