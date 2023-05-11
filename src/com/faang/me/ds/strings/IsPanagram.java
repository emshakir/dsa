/*
 * 				A pangram is a sentence where every letter of the English alphabet appears at least once.
 * 
 * 				Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 * 
 * 				Example 1:
				Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
				Output: true
				Explanation: sentence contains at least one of every letter of the English alphabet.
				
				Input: sentence = "leetcode"
				Output: false
 */

package com.faang.me.ds.strings;

import java.util.HashSet;
import java.util.Set;

public class IsPanagram {

	public static void main(String[] args) {

		String input = CustScanner.nextLine();
//		boolean output1 = checkIfPangram_1(input.toLowerCase());
//		boolean output2 = checkIfPangram_2(input.toLowerCase());
//		boolean output3 = checkIfPangram_3(input.toLowerCase());
		boolean output4 = checkIfPangram_4(input.toLowerCase());
		System.out.println(output4);
	}

	public static boolean checkIfPangram_1(String sentence) {

		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		for (char ch : alphabets.toCharArray()) {

			if (!(sentence.contains(ch + ""))) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkIfPangram_2(String sentence) {

		int[] checker = new int[26];
		for (int i = 0; i < sentence.length(); i++) {
			checker[sentence.charAt(i) - 'a']++;
		}
		for (int i = 0; i < checker.length; i++) {
			if (checker[i] == 0) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkIfPangram_3(String sentence) {
		StringBuffer sb = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		for (int i = 0; i < sb.length(); i++) {
			if (sentence.indexOf(sb.charAt(i)) == -1) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkIfPangram_4(String sentence) {
		Set<Character> set = new HashSet<Character>();
		for (char ch : sentence.toCharArray()) {
			set.add(ch);
		}

		return set.size() == 26 ? true : false;
	}
}
