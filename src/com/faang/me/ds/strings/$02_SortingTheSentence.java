/*
A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.

Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

*/

package com.faang.me.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class $02_SortingTheSentence {

	public static void main(String[] args) {
		String s = "this1 is2 test4 a3";
		System.out.println(sortSentence(s));
		System.out.println(sortSentenceUsingMap(s));
	}

	static String sortSentence(String s) {
		String[] sArray = s.split(" ");
		String[] sortedArr = new String[sArray.length];
		StringBuffer sb = new StringBuffer();
		for (String singleStr : sArray) {
			int i = singleStr.charAt(singleStr.length() - 1) - '0';
			sortedArr[i - 1] = singleStr.substring(0, singleStr.length() - 1);
		}
		for (int i = 0; i < sortedArr.length - 1; i++){
            sb.append(sortedArr[i]).append(" ");
        }
	    sb.append(sortedArr[sortedArr.length-1]);
		return sb.toString();
	}

	static String sortSentenceUsingMap(String s) {
		String[] sArray = s.split(" ");
		String[] sortedArr = new String[sArray.length];
		StringBuilder sb = new StringBuilder();
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (String ele : sArray) {
			int indexPosition = ele.charAt(ele.length() - 1) - '1';
			String value = ele.substring(0, ele.length() - 1);
			map.put(indexPosition, value);
		}
		for (int i = 0; i < map.size()-1; i++) {
			sb.append(map.get(i)+" ");
		}
		sb.append(map.get(sortedArr.length-1));
		return sb.toString();
	}
}
