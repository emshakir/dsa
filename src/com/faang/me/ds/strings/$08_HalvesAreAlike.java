/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

 

Example 1:

Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
Example 2:

Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
Example 3:

Input: s = "MerryChristmas"
Output: false
*/

package com.faang.me.ds.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class $08_HalvesAreAlike {

	public static void main(String[] args) {

		String s = "MerryChristmas";
		System.out.println(halvesAreAlike(s));
	}

	static boolean halvesAreAlike(String s) {

		int count = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			if (isVowel(s.charAt(i))) {
				count++;
			}
		}

		for (int i = s.length() / 2; i < s.length(); i++) {
			if (isVowel(s.charAt(i))) {
				count--;
			}
		}
		if (count == 0) {
			return true;
		}
		return false;
	}

	static boolean isVowel(char ch) {
		String s = "aeiouAEIOU";
		if (s.contains(ch + "")) {
			return true;
		}
		return false;
	}

	static boolean halvesAreAlikeMethod2(String s) {
		Set<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o'));
		String vowels = "aeiouAEIOU";
		for (int i = 0; i < vowels.length(); i++) {
			set.add(vowels.charAt(i));
		}

		int count = 0;
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			count += (set.contains(s.charAt(i))) ? 1 : 0;
			count -= (set.contains(s.charAt(j))) ? 1 : 0;

		}
		return count == 0;
	}
}
