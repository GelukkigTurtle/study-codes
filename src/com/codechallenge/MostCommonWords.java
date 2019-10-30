package com.codechallenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *  Amazon is partnering with the linguistics department at a local university to analyze important works of English literature
 *   and identify patterns in word usage across different eras. To ensure a cleaner output. the linguistics department has provided a list of commonly used words
 *    (e.g., “an”, “the”. etc.) to exclude from the analysis. In the context of this search, a word is an alphabetic sequence of characters having no whitespace or punctuation.

	Write an algorithm to find the most frequently used word in the text excluding the commonly used words.
    Input:
	The input to the function/method consists of two arguments:
	literatureText: a string representing the block of text,
	wordsToExclude: a list of strings representing the commonly used words to be excluded while analyzing the word frequency.
	
	Output:
	Return a list of strings representing the most frequently used word in the text or in case of a tie, all of the most frequently used words in the text..
	
	Note:
	Words that have a different case are counted as the same word. The order of words does not matter in the output list. All words in the ‘wordsToExclude’ list are unique. Punctuation should be treated as white space.
	
	Example
	Input :
	literature Text = “Jack and Jill went to the market to buy bread and cheese. Cheese is Jack’s and Jill’s favorite food.”
	wordsToExclude = [“and”, “he”, “the”, “to”, “is”. “Jack”, “Jill”]
	Output :
	[“cheese”, “s”]
	
	Explanation : The word `and" has a maximum of three frequency but this word should be excluded while analyzing the word frequency. The words “Jack’. 'Jill”, “s”, “to” and “cheese” have the next maximum frequency(two) in the given text but the words “Jack”, “to” and "Jill’ should be excluded as these are commonly used words which you are not interested to include.

 */

public class MostCommonWords {

	public static void main(String[] args) {
		String lteratureText = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill’s favorite food and oh si nena que pedalizas food and pizza.";
		String[] wordsToExclude = {"and", "he", "the", "to", "is", "Jack", "Jill"};
		System.out.println(mostCommonWords(lteratureText, wordsToExclude));

	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }
	
    public static List<String> mostCommonWords(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.stream(banned).map(String::toLowerCase).collect(Collectors.toList());

       // String[] p = paragraph.toLowerCase().split("[ !?',;.]+");

        String[] p = paragraph.toLowerCase().split("\\W");

        List<String> highestFrequencyWordList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int highestFreq = Integer.MIN_VALUE;
        for (String s1 : p) {

            if (!bannedList.contains(s1)) {

                Integer freq = map.getOrDefault(s1, 0);
                map.put(s1, freq + 1);
                if (freq + 1 > highestFreq) {
                    highestFreq = freq + 1;
                }
            }
        }

        for (Map.Entry<String, Integer> es : map.entrySet()) {
            if (es.getValue() == highestFreq) {
                highestFrequencyWordList.add(es.getKey());
            }
        }

        return highestFrequencyWordList;
    }
	
	/*private static List<String> mostFreqWords(String lteratureText, String[] wordsToExclude) {
		Map<String, Integer> map = new HashMap<>();
		String[] words = lteratureText.split("\\W");
		Set<String> ex = new HashSet<>();
		ex.addAll(Arrays.asList(wordsToExclude));
		List<String> res = new ArrayList<String>();
		for(String w : words) {
			if(!ex.contains(w)) {
				w = w.toLowerCase();
				map.put(w, map.getOrDefault(w, 0) + 1);
			}
		}
		int target = 0;
		for(int cnt : map.values()) {
			target = Math.max(target, cnt);
		}
		for(String k : map.keySet()) {
			if(map.get(k) == target) {
				res.add(k);
			}
		}
		return res;
	}*/

}
