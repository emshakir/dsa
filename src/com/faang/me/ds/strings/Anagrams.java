package com.faang.me.ds.strings;

import java.util.Arrays;

public class Anagrams {

	public static void main(String[] args) {

		String string1 = "Software";
		String string2 = "forstwae";
//		String cleaned1 = removeSpecialCharacters(string1.toLowerCase());
//		String cleaned2 = removeSpecialCharacters(string2.toLowerCase());
//
//		String sorted1 = sort(cleaned1);
//		String sorted2 = sort(cleaned2);
//
//		boolean flag = areAnagrams(sorted1, sorted2);
//		if(flag) {
//			System.out.println("YES");
//		} else {
//			System.out.println("NO");
//		}
		
//		boolean status = areAnagramsFunction2(string1, string2);
		boolean status = areAnagramsFunction3(string1, string2);
		System.out.println(status);
	}

	public static String removeSpecialCharacters(String string) {
		StringBuilder sb = new StringBuilder(string.length());
		for (int i = 0; i < string.length(); i++) {
			if (Character.isAlphabetic(string.charAt(i))) {
				sb.append(string.charAt(i));
			}
		}
		return sb.toString();
	}

	protected static String sort(String string) {
		char[] sorted = string.toCharArray();
		Arrays.sort(sorted);
		return new String(sorted);
	}

	protected static boolean areAnagrams(String s1, String s2) {

		if (s1.equalsIgnoreCase(s2)) {
			return true;
		}
		return false;
	}
	
	static boolean areAnagramsFunction2(String s1, String s2) {
		
		if(s1.length() != s2.length()) {
			return false;
		}

		int[] count = new int[256];
		for(int i=0;i<s1.length();i++) {
			char ch = s1.charAt(i);
			count[ch]++;
		}
		
		for(int i=0;i<s2.length();i++) {
			char ch = s1.charAt(i);
			count[ch]--;
		}
		
		for(int i=0;i<s1.length();i++) {
			if(count[s1.charAt(i)] != 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean areAnagramsFunction3(String stringOne, String stringTwo) {
		char[] first = stringOne.toLowerCase().toCharArray(); 
        char[] second = stringTwo.toLowerCase().toCharArray();
        // if length of strings is not same 
        if (first.length != second.length)
            return false;
        int[] counts = new int[26];    // s o f t w a r  e      //   f o r  s t w a e 
        for (int i = 0; i < first.length; i++){
//        	int ch1 = first[i];
        	int num1 = first[i]-97;  
            counts[num1]++;					// 18 - 1 14 - 1 5 - 1 19 - 1 
//            int ch2 = second[i];
            int num2 = second[i]-97;		// 5 - 1  14 - 1 17 - 1 
            counts[num2]--;   
        }
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
	}
}
























