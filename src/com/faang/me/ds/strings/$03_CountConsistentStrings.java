/*
You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

 

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.
Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
*/

package com.faang.me.ds.strings;

import java.util.HashSet;
import java.util.Set;

public class $03_CountConsistentStrings {

	public static void main(String[] args) {
		String allowed = "abc";
		String[] words = { "a","b","c","ab","ac","bc","abc" };
		System.out.println(countConsistentStrings(allowed, words));
		System.out.println(countConsistentStringsMethodTwo(allowed, words));
	}

	static int countConsistentStrings(String allowed, String[] words) {
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			boolean flag = true;
			for (int j = 0; j < words[i].length(); j++) {
				if (allowed.indexOf(words[i].charAt(j)) == -1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
		}
		return count;
	}

	static int countConsistentStringsMethodTwo(String allowed, String[] words) {
		int count = words.length;
		Set<Character> set = new HashSet<Character>();
		for (char ch : allowed.toCharArray()) {
			set.add(ch);
		}
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				if (!set.contains(word.charAt(i))) {
					count--;
					break;
				}
			}
		}
		return count;
	}
}
