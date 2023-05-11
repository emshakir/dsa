/*
 * 		Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 * 
 *		Example 1:
		Input: s = "RLRRLLRLRL"
		Output: 4
		Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.	 
		
		Input: s = "RLLLLRRRLR"
		Output: 3
		Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
		
		Input: s = "LLLLRRRR"
		Output: 1
		Explanation: s can be split into "LLLLRRRR".
		
		Input: s = "RLRRRLLRLL"
		Output: 2
		Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R' 
 */

package com.faang.me.ds.strings;

public class BalancedString {

	public static void main(String[] args) {
		String input = CustScanner.nextLine();
		int output = balancedStringSplit(input);
		int output2 = balancedStringSplit_2(input);
		System.out.println(output);
		System.out.println(output2);

	}

	public static int balancedStringSplit(String s) {

		int output = 0;
		int balanceVariable = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L') {
				balanceVariable++;
			} else {
				balanceVariable--;
			}

			if (balanceVariable == 0) {
				output++;
			}
		}
		return output;
	}

	public static int balancedStringSplit_2(String s) {

		int count = 0;
		int balancedeString = 0;

		for (int i = 0; i < s.length(); i++) {
			balancedeString += (s.charAt(i) == 'L') ? 1 : -1;
			if(balancedeString == 0) {
				count++;
			}
		}
		System.gc();
		return count;
	}
}
