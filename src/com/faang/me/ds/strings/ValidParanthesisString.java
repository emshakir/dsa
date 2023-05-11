/*
 * 			Example 1:

				Input: s = "(1+(2*3)+((8)/4))+1"
				Output: 3
				Explanation: Digit 8 is inside of 3 nested parentheses in the string.
				
			Example 2:
			
				Input: s = "(1)+((2))+(((3)))"
				Output: 3
				
			Example 3:
			
				Input: s = "1+(2*3)/(2-1)"
				Output: 1
				
			Example 4:
			
				Input: s = "1"
				Output: 0
			
	For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
	
	Given a VPS represented as string s, return the nesting depth of s.	
 * 
 * 
 */

package com.faang.me.ds.strings;

import java.util.Stack;

public class ValidParanthesisString {

	public static void main(String[] args) {
		String s = CustScanner.nextLine();
		int output1 = maxDepth_1(s);
//		int output2 = maxDepth_2(s);
		System.out.println(output1);
	}

	public static int maxDepth_1(String s) {

		// s = "(1+(2*3)+((8)/4))+1"
		
		// s = "(1)+((2))+(((3)))"

		int count = 0;  		//  1 2 2 2 3 3 3 3					//  1 1 1 2 2 2 2 2 3 3 3 3
		int current = 0;		//  1 2 1 2 3 2 1 0					//  1 0 1 2 1 0 1 2 3 2 1 0

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				count = Math.max(count, ++current);
			}
			if (ch == ')') {
				current--;
			}
		}
		return count;
	}
	
	public static int maxDepth_2(String s) {
	
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for(int i =0;i< s.length();i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
				count = Math.max(count, stack.size());
			} else if(s.charAt(i) == ')') {
				stack.pop();
			} 
		}
		return count;
	}

}
