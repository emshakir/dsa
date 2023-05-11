/*
Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"
	*/
package com.faang.me.ds.strings;

public class $09_DecryptStringFromAlphabet {

	public static void main(String[] args) {
		String s = "10#11#1";
		System.out.println(freqAlphabetsMethodTwp(s));
	}

	static String freqAlphabets(String s) {
		StringBuilder output = new StringBuilder(); // used stringbuiled append b/c it's optimized

		for (int i = s.length() - 1; i >= 0; i--) { // starts from last character, goes till first character

			if (s.charAt(i) == '#') {
				System.out.println("CHAR-1::::::::::" + (s.charAt(i - 1) - '0'));
				System.out.println("CHAR-2:::::::::" + 10 * (s.charAt(i - 2) - '0'));
				System.out.println("CHAR-3:::::" + ('a' + (s.charAt(i - 1) - '0') + 10 * (s.charAt(i - 2) - '0') - 1));
				output.append((char) ('a' + (s.charAt(i - 1) - '0') + 10 * (s.charAt(i - 2) - '0') - 1));
				// using ascii, add 'a' to start from the alphabet, subtract '0' b/c currently
				// the digits in the String s are chars

				i -= 2; // have skip 2 characters , b/c we already checked it in the above line
			} else {
				output.append((char) ('a' + (s.charAt(i) - '0') - 1));
			}
		}
		output.reverse(); // very helpful method, reverses the whole string

		return output.toString(); // convert StringBuilder obj to string
	}

	static String freqAlphabetsMethodTwp(String s) {
		int n = s.length();
		String ans = "";
		for (int i = 0; i < n;) {
			if (i < n - 2 && s.charAt(i + 2) == '#') {
				int num = Integer.parseInt(s.substring(i, i + 2));
				ans += (char) (num + 96);
				i = i + 3;
				continue;
			}
			ans += (char) (97 + s.charAt(i) - '1');
			i++;
		}
		return ans;
	}
}
