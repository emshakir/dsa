package com.faang.me.ds.strings;

import java.util.Arrays;

public class TwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		String[] word1 = {"ab", "c"};
		String[] word2 = {"a", "bc"};
		
		boolean output = arrayStringsAreEqual(word1, word2);
		System.out.println(output);
	}
	
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		
		System.out.println(Arrays.toString(word1));
		return (Arrays.toString(word1).equalsIgnoreCase(Arrays.toString(word2))) ? true :false;
		
	}
}
