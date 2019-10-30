package com.codechallenge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringsOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ch = "abcbaa"; 
        int k = 3; 
        System.out.println(lengthOfLongestSubstring(ch, k));
	}
	
	 // Time Complexity - O(N) where N is length of input string s
    public static List<String> lengthOfLongestSubstring(String s, int k) {
        if (s == null || s.isEmpty())
            return new ArrayList<>();

        if (s.length() < k) {
            return new ArrayList<>();
        }


        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        while (end <= s.length() - 1) {

            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                //update start and end
                int lastIndex = map.get(s.charAt(end));
                start = lastIndex + 1;
            }


            map.put(s.charAt(end), end);
            if (end - start + 1 == k) {

                if(!result.contains(s.substring(start, end + 1))){
                    result.add(s.substring(start, end + 1));
                }

                map.remove(s.charAt(start));
                start++;
            }

            end++;
        }
        return result;
    }

}
