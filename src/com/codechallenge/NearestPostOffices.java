package com.codechallenge;

import java.util.Arrays;

/*
 *  Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
	Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
	Euclidean distance is applied to find the distance between you and a post office.
	Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
	K is a positive integer much smaller than the given number of post offices.
	
	e.g.
	Input
	you: [0, 0]
	post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
	k = 3
	
	Output 
	[[-1, 2], [0, 3], [4, 3]]
 * 
 * 
 */



public class NearestPostOffices {

	public static void main(String[] args) {
		int k = 3;
		int[][] post_offices = {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
		System.out.println(Arrays.toString(post_offices));
		int[][] result = kClosest(post_offices,k);
		for(int[] r : result) {
			System.out.println(Arrays.toString(r));

		}
	}
	
	 public static int[][] kClosest(int[][] points, int K) {
	        int N = points.length;
	        int[] dists = new int[N];
	        for (int i = 0; i < N; ++i)
	            dists[i] = dist(points[i]);

	        Arrays.sort(dists);
	        int distK = dists[K-1];

	        int[][] ans = new int[K][2];
	        int t = 0;
	        for (int i = 0; i < N; ++i)
	            if (dist(points[i]) <= distK)
	                ans[t++] = points[i];
	        return ans;
	    }

	    public static  int dist(int[] point) {
	        return point[0] * point[0] + point[1] * point[1];
	    }

}
