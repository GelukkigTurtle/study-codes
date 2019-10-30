package com.codechallenge;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * numberOfBoxes =6;
 * boxList = 
 * [ykc 82 01]
 * [eo first qpx]
 * [09z cat hamster]
 * [06f 12 25 6]
 * [az0 first qpx]
 * [236 cat dog rabbit snake]
 * 
 * Output:
 * [236 cat dog rabbit snake]
 * [09z cat hamster]
 * [az0 first qpx]
 * [eo first qpx]
 * [ykc 82 01]
 * [06f 12 25 6]
 */

public class JunctionBoxes {

	public static void main(String[] args) {
		int numberOfBoxes = 6;
		String[] boxes = {"ykc 82 01",
				 		  "eo first qpx",
						  "09z cat hamster",
						  "05f 10 25 6",
						  "06f 12 25 6",
						  "az0 first qpx",
						  "236 cat dog rabbit snake"};
		System.out.println("Ordered junction boxes: ");
		
		
		String[] output = orderBoxes(boxes, numberOfBoxes);
		//System.out.println(Arrays.toString(orderBoxes(boxes, numberOfBoxes)));
		for(int i =0; i<output.length; i++) 
			System.out.println("[" + output[i] + "]");
	}

	private static String[] orderBoxes(String[] boxes, int len) {
		if(len>0) {
			String[] output = new String[len];
			Queue<String> queue = new LinkedList<>();
			int index = 0;
			TreeMap<String, TreeSet<String>> tm = new TreeMap<>();
			TreeSet<String> heads = new TreeSet<String>();
			
			for(int i=0;i<len; i++) {
				int space = boxes[i].indexOf(' ');
				String head = boxes[i].substring(0, space);
				String body = boxes[i].substring(space+1);
				
				String newBody = body.replace(" ", "");
				String conBody = newBody.replaceAll("\\D+", "");
				if (!conBody.isEmpty()) {
					queue.offer(boxes[i]);
				} else {
					if(!tm.containsKey(body))
						heads = new TreeSet<String>();
					else 
						heads = tm.get(body);
					heads.add(head);
					tm.put(body, heads);
				}
			}
			
			for (Entry<String, TreeSet<String>> entry : tm.entrySet()) {				
					TreeSet<String> ts = entry.getValue();
					for(String t: ts) {
						output[index++] = t +  " " + entry.getKey(); 				
				}
			}
	            			
			while(!queue.isEmpty() && index<len)
				output[index++] = queue.poll();
			return output;
		}
		return null;		
	}
	
	
	 
}
