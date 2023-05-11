/*
 * You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
 * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". 
 * The interpreted strings are then concatenated in the original order.

		Given the string command, return the Goal Parser's interpretation of command.

	Example 1:

		Input: command = "G()(al)"
		Output: "Goal"
		Explanation: The Goal Parser interprets the command as follows:
		
		G -> G
		() -> o
		(al) -> al
		The final concatenated result is "Goal".
		
	Example 2:

		Input: command = "G()()()()(al)"
		Output: "Gooooal"
 */

package com.faang.me.ds.strings;

public class GoalParserInterPretation {

	public static void main(String[] args) {
		String input = CustScanner.nextLine();

		String output = interpret_3(input);
		System.out.println(output);
	}

	public static String interpret_1(String command) {
		String output = "";
		output = command.replace("G", "G");
		output = output.replace("()", "o");
		return output.replace("(al)", "al");
	}

	public static String interpret_2(String command) {
		return command.replace("()", "o").replace("(al)", "al");
	}

	public static String interpret_3(String command) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < command.length(); i++) {
			char ch = command.charAt(i);
			if (ch == 'G') {
				sb.append("G");
			} else if (ch == '(' && command.charAt(i + 1) == ')') {
				sb.append("o");
				i++;
			} else {
				sb.append("al");
				i += 3;
			}
		}
		return sb.toString();
	}
}
