package com.faang.me.ds.strings;

public class Palindrome {

	public static void main(String[] args) {
		String s1 = CustScanner.next();
		StringBuffer sb = new StringBuffer(s1);
		String reversedString = sb.reverse().toString();
		if(s1.equalsIgnoreCase(reversedString)) {
			System.out.println("Yes, it is!");
		} else {
			System.out.println("No, it is not!");
		}
	}
}
