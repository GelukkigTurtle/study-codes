package com.codechallenge;
/**
 * 
 * You are given with a string . Your task is to remove at most two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is to maximise the length of the remaining string. Output the length of remaining string after removal of at most two substrings.
	NOTE: The answer may be 0, i.e. removing the entire string.
	
	Sample Input
	2
	earthproblem
	letsgosomewhere
	Sample Output
	3
2
 * @author freddy
 *
 */
public class LongestStringMadeUpOfOnlyVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "letsgosomewhere"; 
	    System.out.println(longestVowel(s)); 
	}
	
	 static boolean isVowel(char c) 
	    { 
	        return (c == 'a' || c == 'e' || c == 'i' 
	                 || c == 'o' || c == 'u'); 
	    } 
	  
	    static int longestVowel(String str) 
	    { 
	        int count = 0, res = 0; 
	        char[] s = str.toCharArray(); 
	          
	        for (int i = 0; i < s.length; i++)  
	        { 
	  
	            // Increment current count  
	            // if s[i] is vowel  
	            if (isVowel(s[i]))  
	            count++;      
	  
	            else 
	            { 
	                // check previous value  
	                // is greater then or not 
	                res = Math.max(res, count); 
	  
	                count = 0; 
	            } 
	        } 
	          
	    return res; 
	    } 
	  

}
