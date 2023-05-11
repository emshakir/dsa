/*
 
 	Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

	A substring is a contiguous sequence of characters within a string.

	
	Example 1:

			Input: patterns = ["a","abc","bc","d"], word = "abc"
			Output: 3
			Explanation:
			- "a" appears as a substring in "abc".
			- "abc" appears as a substring in "abc".
			- "bc" appears as a substring in "abc".
			- "d" does not appear as a substring in "abc".
			3 of the strings in patterns appear as a substring in word.
			
			
	Example 2:

			Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
			Output: 2
			Explanation:
			- "a" appears as a substring in "aaaaabbbbb".
			- "b" appears as a substring in "aaaaabbbbb".
			- "c" does not appear as a substring in "aaaaabbbbb".
			2 of the strings in patterns appear as a substring in word.
 
 	
 */

package com.faang.me.ds.strings;

public class $12_NumberOfStringsAppearAsSubstring {

	public static void main(String[] args) {

		String[] patterns = { "a","b","c" };
		String word = "aaaaabbbbb";
//		String[] patterns = { "a", "abc", "bc", "d" };
//		String word = "abc";
		System.out.println("Count:::::" + numOfStrings(patterns, word));
	}

	static int numOfStrings(String[] patterns, String word) {
		int count = 0;
		for (String pattern : patterns) {
			if (word.contains(pattern)) {
				count++;
			}

		}
		return count;
	}

}
