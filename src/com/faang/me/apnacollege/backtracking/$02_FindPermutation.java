package com.faang.me.apnacollege.backtracking;

class $02_FindPermutation {
	
	public static void findPermutation(String input, String output) {
		
		if(input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		// get ith character and add it to output and remove from input
		// recursively do the same untill string length is 0, then print the output
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			String newString = input.substring(0, i) + input.substring(i + 1);
			findPermutation(newString, output + ch);
		}	
	}
	
	public static void main(String[] args) {
		final String INPUT_DATA = "abc";
		findPermutation(INPUT_DATA, "");
	}
}