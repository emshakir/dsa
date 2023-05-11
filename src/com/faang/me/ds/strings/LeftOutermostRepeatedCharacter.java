package com.faang.me.ds.strings;

public class LeftOutermostRepeatedCharacter {

	public static void main(String[] args) {

		String string = "zlgeeksforgeeks"; // s - 12, k - 11, e - 10, e - 9
		int requirdIndex = leftMostuniqueStringIndex(string);
		System.out.println(requirdIndex);
	}

	static int leftMostuniqueStringIndex(String string) {
		int resultant = Integer.MAX_VALUE;

		int[] alpSize = new int[256];
		for (int i = 0; i < alpSize.length; i++) {
			alpSize[i] = -1;
		}

		for (int i = 0; i <= string.length()-1; i++) {
			char ch = string.charAt(i);
			if (alpSize[ch] == -1) {
				alpSize[ch] = i;
			} else {
				resultant = Math.min(resultant, alpSize[ch]);
			}
		}
		return (resultant == Integer.MAX_VALUE) ? -1 : resultant;

	}
}
