package com.codechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//		String[] logs = {"l5sh 6 3869 08 1295", "16o 94884717383724 9", "43 490972281212 3 51", "9 ehyjki ngcoobi mi", "2epy 85881033085988", "7z fqkbxxqfks f y dg", "9h4p 5 791738 954209", "p i hz uubk id s m l", "wd lfqgmu pvklkdp u", "m4jl 225084707500464", "6np2 bqrrqt q vtap h", "e mpgfn bfkylg zewmg", "ttzoz 035658365825 9", "k5pkn 88312912782538", "ry9 8231674347096 00", "w 831 74626 07 353 9", "bxao armngjllmvqwn q", "0uoj 9 8896814034171", "0 81650258784962331", "t3df gjjn nxbrryos b"};

public class LogFile {

	public static void main(String[] args) {
		String[] logs = {"l5sh 6 3869 08 1295", "16o 94884717383724 9", "43 490972281212 3 51", "9 ehyjki ngcoobi mi", "2epy 85881033085988", "7z fqkbxxqfks f y dg", "9h4p 5 791738 954209", "p i hz uubk id s m l", "wd lfqgmu pvklkdp u", "m4jl 225084707500464", "6np2 bqrrqt q vtap h", "e mpgfn bfkylg zewmg", "ttzoz 035658365825 9", "k5pkn 88312912782538", "ry9 8231674347096 00", "w 831 74626 07 353 9", "bxao armngjllmvqwn q", "0uoj 9 8896814034171", "0 81650258784962331", "t3df gjjn nxbrryos b"};
		System.out.println(Arrays.toString(Solution.reorderLogFiles(logs)));
	}
	
	 static class Solution {
	    public static String[] reorderLogFiles(String[] logs) {
	        if (logs == null || logs.length == 0) return logs;
	        int len = logs.length;
	        List<String> letterList = new ArrayList<>();
	        List<String> digitList = new ArrayList<>();
	        for (String log : logs) {
	            if (log.split(" ")[1].charAt(0) < 'a') {
	                digitList.add(log);
	            } else {
	                letterList.add(log);
	            }
	        }
	        Collections.sort(letterList, (o1, o2) -> {
	            String[] s1 = o1.split(" ");
	            String[] s2 = o2.split(" ");
	            int len1 = s1.length;
	            int len2 = s2.length;
	            for (int i = 1; i < Math.min(len1, len2); i++) {
	                if (!s1[i].equals(s2[i])) {
	                    return s1[i].compareTo(s2[i]);
	                }
	            }
	            return 0;
	        });

	        for (int i = 0; i < len; i++) {
	            if (i < letterList.size())
	                logs[i] = letterList.get(i);
	            else logs[i] = digitList.get(i - letterList.size());
	        }
	        return logs;
	    }
	}

}
