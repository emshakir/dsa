package com.faang.me.ds.strings;

import java.util.HashMap;
import java.util.Map;

public class ShuffleString {

	public static void main(String[] args) {
		String s = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		restoreString(s, indices);
	}

	static String restoreString(String s, int[] indices) {
		Map<Integer, Character> map = new HashMap<>();
		int j = 0;
		for (int i : indices) {
			map.put(i, s.charAt(j));
			j++;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer i : map.keySet()) {
			sb.append(map.get(i));
		}
		return sb.toString();
	}
	
	static String restoreStringMethod2(String s, int[] indices) {
		
		char[] charArray = new char[indices.length];
		for(int i=0;i<s.length();i++) {
			charArray[indices[i]] = s.charAt(i);
		}
		
		return new String(charArray);
	}
}
