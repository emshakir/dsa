package com.faang.me.ds.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		String[] strArray = new String[] { "Java", "PHP", ".NET", "PERL", "C", "COBOL" };

		String newString = Arrays.toString(strArray);
		System.out.println(newString);

		newString = newString.substring(1, newString.length() - 1);

		System.out.println("New New String: " + newString);

		String str = Arrays.asList("a", "b", "c").stream().collect(Collectors.joining());
		System.out.println(str);

		String s1 = "Remove Last CharacterY";
		String s2 = "Remove Last Character2";
		
		System.out.println("After removing s1==" + removeLastChar(s1) + "==");
		System.out.println("After removing s2==" + removeLastChar(s2) + "==");
		
		System.out.println(s1.substring(s1.length() - 1));
		System.out.println(s2.substring(0, s2.length() - 1));

		String s = "SachinTendulkar";
		System.out.println(s.substring(6));// Tendulkar
		System.out.println(s.substring(0, s.length()));// Sachin
	}

	public static String removeLastChar(String str) {
		return removeLastChars(str, 1);
	}

	public static String removeLastChars(String str, int chars) {
		return str.substring(0, str.length() - chars);
	}

}
