package com.faang.arrays;

import java.util.ArrayList;
import java.util.List;

public class $07_1239_MaximumLengthString {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		arr.add("ab");
		arr.add("ab");
		arr.add("cd");
		System.out.println("OUTPUT::::::"+maxLength(arr));;

	}

	public static int maxLength(List<String> arr) {
		return maxLength(arr, 0, "");
	}

	private static int maxLength(List<String> arr, int i, String ele) {

		if (arr.size() == i) {
			int[] freq = new int[26];
			for (int k = 0; k < ele.length(); k++) {

				if (freq[ele.charAt(k) - 'a'] == 1) {
					return 0;
				}

				freq[ele.charAt(k) - 'a']++;
			}
			return ele.length();
		}
		int opt1 = Integer.MAX_VALUE;
		int opt2 = opt1;
		if (arr.get(i).length() + ele.length() <= 26) {
			System.out.println(arr.get(i).length() + ele.length());
			opt1 = maxLength(arr, i + 1, ele + arr.get(i));
			System.out.println(opt1);
		}
		opt2 = maxLength(arr, i + 1, ele);
		System.out.println(opt2);
		int output = Math.max(opt1, opt2);
		return output;
	}
}
