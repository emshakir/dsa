/*
A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.

Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.

 

Example 1:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
*/
package com.faang.me.ds.strings;

public class $06_RemoveOuterParentheses {

	public static void main(String[] args) {
		String s = "(()())(())(()(()))";
		System.out.println(removeOuterParentheses(s));
		System.out.println(removeOuterParenthesesMethod2(s));
	}

	static String removeOuterParentheses(String s) {

		StringBuffer output = new StringBuffer();
		int opened = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' && opened++ > 0) {
				output.append(ch);
			}
			if (ch == ')' && opened-- > 1) {
				output.append(ch);
			}
		}
		return output.toString();
	}
	
	static String removeOuterParenthesesMethod2(String s) {
		//             012345 6789
		// Input: s = "(()()) (())(()(()))"
		// 		       121210 1210
		StringBuffer sb = new StringBuffer();
		int bracketsCount = 0;
		int start = 0;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				bracketsCount++;
			}
			if(ch == ')') {
				bracketsCount--;
			}
			if(bracketsCount == 0) {
				sb.append(s.substring(start+1, i));
				start=i+1;
			}
		}
		return sb.toString();
		
	}
}
