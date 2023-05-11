/*
 You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.

There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.

For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).

Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.

Example 1:

Input: s = "a1c1e1"
Output: "abcdef"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('c',1) = 'd'
- s[5] -> shift('e',1) = 'f'
Example 2:

Input: s = "a1b2c3d4e"
Output: "abbdcfdhe"
Explanation: The digits are replaced as follows:
- s[1] -> shift('a',1) = 'b'
- s[3] -> shift('b',2) = 'd'
- s[5] -> shift('c',3) = 'f'
- s[7] -> shift('d',4) = 'h'
 */
package com.faang.me.ds.strings;

public class $05_ReplaceDigitsWIthChar {

	static char ch;

	public static void main(String[] args) {
		String s = "a1b2c3d4e";
		System.out.println("OUTPUT:::::" + replaceDigits(s));
		System.out.println("OUTPUT:::::" + replaceDigitsMethodTwo(s));
	}

	static String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i % 2 == 0) {
				sb.append(s.charAt(i));
			} else {
				sb.append((char) (s.charAt(i - 1) + s.charAt(i) - '0'));
			}
		}
		return sb.toString();
	}

	static String replaceDigitsMethodTwo(String s) {
		char[] charArr = s.toCharArray();
		for (int i = 1; i < charArr.length; i += 2) {
			charArr[i] = (char) (charArr[i - 1] + (charArr[i] - '0'));
		}
		return String.valueOf(charArr);
	}

}
