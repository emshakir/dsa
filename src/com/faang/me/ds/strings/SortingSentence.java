/*
 * 		Example 1:

			Input: s = "is2 sentence4 This1 a3"
			Output: "This is a sentence"
			Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
		Example 2:

			Input: s = "Myself2 Me1 I4 and3"
			Output: "Me Myself and I"
			Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
 * 
 * 
 */

package com.faang.me.ds.strings;

public class SortingSentence {

	public static void main(String[] args) {

		System.out.println(sortSentence(CustScanner.nextLine()));
	}

	public static String sortSentence(String s) {
		
			String[] sArray = s.split(" ");
			
			for(int i = 0;i < sArray.length ; i++) {
				System.out.println(sArray[i].substring(sArray[i].length()-1));
			}
		return "";
	}
}
