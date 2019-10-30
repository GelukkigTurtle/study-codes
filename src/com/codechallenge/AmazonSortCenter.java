package com.codechallenge;
import java.util.Arrays;

/*
 * In Amazon’s sort center, a computer system decides what packages are to be loaded on what trucks. All rooms and spaces are abstracted into space units which is represented as an integer. For each type of truck, they have different space units. For each package, they will be occupying different space units. As a software development engineer in sort centers, you will need to write a method:
	
	Given truck space units and a list of product space units, find out exactly TWO products that fit into the truck. You will also implement an internal rule that the truck has to reserve exactly 30 space units for safety purposes. Each package is assigned a unique ID, numbered from 0 to N-1.
	
	Assumptions:
	You will pick up exactly 2 packages.
	You cannot pick up one package twice.
	If you have multiple pairs, select the pair with the largest package.
	
	Input:
	The input to the function/method consists of two arguments :
	truckSpace , an integer representing the truck space.
	packagesSpace , a list of integers representing the space units occupying by packages.
	
	Output:
	Return a list of integers representing the IDs of two packages whose combined space will leave exactly 30 space units on the truck.
	
	Example
	Input :
	truckSpace = 90
	packagesSpace = [1, 10, 25, 35, 60]
	Output :
	[2, 3]
	Explanation : Given a truck of 90 space units, a list of packages space units [1, 10, 25, 35, 60], Your method should select the third(ID-2) and fourth(ID-3) package since you have to reserve exactly 30 space units.
 * 
 * 
 */

public class AmazonSortCenter {

	public static void main(String[] args) {
		int [] nums =  new int [] {1, 10, 25, 35, 60};
		int d = 90;
		int[] result = sumclosest(nums,d);
		System.out.println(Arrays.toString(result));

	}
	
	public static int[] sumclosest(int [] nums, int d){
		int [] result = new int [2];
		if( nums == null || nums.length==0|| d<30){
			return result;
		}
		
		int max = Integer.MIN_VALUE;
		Arrays.sort(nums);
		int i=0; int j = nums.length-1;
		
		while(i<j){
	        if(nums[i]+nums[j]<d-30){
	        	if((nums[i]+nums[j])>max){
					max = nums[i]+nums[j];
					result[0] =nums[i];
					result[1] =nums[j];
				}
	        	i++;
	        }else if(nums[i]+nums[j]>d-30){
	        	j--;
	        }
	        else{
	        	result[0] =i;
				result[1] =j;
				break;
	        }			
		}
		return result;
	}

}
