/*
Given a string s. You should re-order the string using the following algorithm:

Pick the smallest character from s and append it to the result.
Pick the smallest character from s which is greater than the last appended character to the result and append it.
Repeat step 2 until you cannot pick more characters.
Pick the largest character from s and append it to the result.
Pick the largest character from s which is smaller than the last appended character to the result and append it.
Repeat step 5 until you cannot pick more characters.
Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

Example 1:

Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"
Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
After steps 4, 5 and 6 of the first iteration, result = "abccba"
First iteration is done. Now s = "aabbcc" and we go back to step 1
After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
*/
package com.faang.me.ds.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class $10_IncreasingDecreasingString {

	public static void main(String[] args) {
		String s = "ggggggg";
		System.out.println(sortString(s));
	}

	static String sortString(String s) {

		char[] charArray = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (char ch : charArray) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		System.out.println(map.size());
		StringBuffer sb = new StringBuffer();
		for (int i = sb.toString().length(); i < charArray.length; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (map.containsKey(ch) && map.get(ch) > 0) {
					sb.append(ch);
					map.put(ch, map.get(ch) - 1);
				}
			}
			for (char chr = 'z'; chr >= 'a'; chr--) {
				if (map.containsKey(chr) && map.get(chr) > 0) {
					sb.append(chr);
					map.put(chr, map.get(chr) - 1);
				}
			}
		}
		return sb.toString();
	}

	static String sortStringMethodTwo(String s) {
		int len = s.length();
		int[] freq = new int[26];
		for (int index = 0; index < len; index++) {
			freq[s.charAt(index) - 'a']++;
		}
		StringBuilder sb = new StringBuilder(len);
		while (sb.toString().length() < len) {
			// sorting up
			for (int i = 0; i < 26; i++) {
				if (freq[i] > 0) {
					sb.append((char) (i + 'a'));
					freq[i]--;
				}
			}
			// sorting down
			for (int i = 25; i >= 0; i--) {
				if (freq[i] > 0) {
					sb.append((char) (i + 'a'));
					freq[i]--;
				}
			}
		}
		return sb.toString();
	}
}
