package com.codechallenge;

import java.util.Arrays;

/*
 *  You are on a flight and wanna watch two movies during this flight.
	You are given int[] movie_duration which includes all the movie durations.
	You are also given the duration of the flight which is d in minutes.
	Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
	Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

	e.g.
	Input
	movie_duration: [90, 85, 75, 60, 120, 150, 125]
	d: 250
	
	Output from aonecode.com
	[90, 125]
	90min + 125min = 215 is the maximum number within 220 (250min - 30min)

 */
public class MoviesOnFlight {

	public static void main(String[] args) {
		int[] movie_duration = {90,85,75,60,120,150,125};
		int d = 100;
		System.out.println(Arrays.toString(movie_duration));
		System.out.println(Arrays.toString(getPairOfMovies(movie_duration,d)));
	}
	
	private static int[] getPairOfMovies(int[] movie_duration, int d){
		int[] movies = new int[] {0,0};
		// 1- Sort the array
		Arrays.sort(movie_duration);
		// 2 - get left and right index
		int l = 0, r = movie_duration.length -1;
		int max = 0;
		int max_duration = d - 30;
		System.out.println("max duration = "+max_duration);
		//3 - iterate over the index with while
		while(l < r) {
			//sum corners of the array
			int sum = movie_duration[l] + movie_duration[r];
			//check if the sum is the greatter
			if(sum > max && sum <= max_duration) {
				//store the current max values 
				max = sum;
				movies[0] = movie_duration[l];
				movies[1] = movie_duration[r];
				//check if the sum is greater than the duration

			}else if(sum > max_duration)
				r--; // move right index to left
			else
				l++; //move the left index to the right
			
		}
		int result =movies[0]+ movies[1];
		System.out.println("Sum of 2 movies = "+result);

		return movies;
	}
 
}
