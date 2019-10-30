package com.codechallenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value.
 *  Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. 
 *  Return a list of ids of selected elements. If no pair is possible, return an empty list.

	Example 1:
	
	Input:
	a = [[1, 2], [2, 4], [3, 6]]
	b = [[1, 2]]
	target = 7
	
	Output: [[2, 1]]
	
	Explanation:
	There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
	Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
	Example 2:
	
	Input:
	a = [[1, 3], [2, 5], [3, 7], [4, 10]]
	b = [[1, 2], [2, 3], [3, 4], [4, 5]]
	target = 10
	
	Output: [[2, 4], [3, 2]]
	
	Explanation:
	There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
	Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
	These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 * 
 * @author freddy
 *
 */
public class OptimalUtilization {

	public static void main(String[] args) {
		int[][] a1 = {{1, 2}, {2, 4}, {3, 6}};
		int[][]	b1 = {{1, 2}};
		int	target1 = 7;
		for(int[] ele : getOptimalUtilization(a1, b1, target1)) {
			System.out.println(Arrays.toString(ele));
		}
		System.out.println("----------------------------");
		int[][] a2 = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int target2 = 10;
		for(int[] ele : getOptimalUtilization(a2, b2, target2)) {
			System.out.println(Arrays.toString(ele));
		}
		System.out.println("----------------------------");
		int[][] a3 =  {{1, 8}, {2, 15},{3,9}};
		int[][] b3 =  {{1, 8}, {2, 11},{3 ,12}};
		int target3 = 20;
		for(int[] ele : getOptimalUtilization(a3, b3, target3)) {
			System.out.println(Arrays.toString(ele));
		}
	}
	
	public static List<int[]> getOptimalUtilization(int [][] a, int[][] b, int target) {
        List<int[]> equal = new ArrayList<>();
        HashMap<Integer,int[]> less = new HashMap<>();
        if(a.length == 0 || b.length == 0) return equal;
        for(int i=0;i<a.length;i++){
            for(int j = 0;j<b.length;j++) {
                if(a[i][1]+b[j][1]==target){
                    equal.add(new int[]{a[i][0],b[j][0]});
                } else if (a[i][1]+b[j][1]<target) {
                    less.put(a[i][1]+b[j][1],new int[]{a[i][0],b[j][0]});
                }
            }
        }
        
        if(equal.isEmpty()){
            ArrayList<Integer> al = new ArrayList<>();
	    for (Integer m : less.keySet()) {
	        al.add(m);
	    }
            int max = 0;
	    for (int i=0; i<al.size();i++) {
	        if (al.get(i)> max) {
	            max = al.get(i);
	        }
	    }
            equal.add(less.get(max));
            return equal;
        }
       return equal;
    }

	

}
