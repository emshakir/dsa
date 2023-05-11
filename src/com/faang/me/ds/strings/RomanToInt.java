package com.faang.me.ds.strings;

import java.util.HashMap;

public class RomanToInt {

	public static void main(String[] args) {
		String romanNumber = CustScanner.next();
		int output4 = romanToInt_4(romanNumber);
		int output3 = romanToInt_3(romanNumber);
		int output2 = romanToInt_2(romanNumber);
		int output1 = romanToInt_1(romanNumber);
		System.out.println(output3);
		System.out.println("\n" + output2);
		System.out.println("\n" + output1);
		System.out.println("\n" + output4);
	}

	public static int romanToInt_4(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int output = 0;
		char preValue = 'M';
		for (char ch : s.toCharArray()) {
			if (map.get(ch) < map.get(preValue)) {
				output -= map.get(ch);
			} else {
				output += map.get(ch);
			}

			preValue = ch;
		}
		return output;
	}

	public static int romanToInt_3(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int sum = 0;
		char prechar = 'M';
		for (char c : s.toCharArray()) {
			int currValue = map.get(c);
			int preValue = map.get(prechar);

			if (currValue > preValue) {
				sum = sum - 2 * preValue;
			}
			sum = sum + currValue;
			prechar = c;
		}

		return sum;
	}

	public static int romanToInt_2(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int output = 0;
		int currentValue = 0;
		int previousValue = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			currentValue = map.get(ch);
			if (currentValue >= previousValue) {
				output += currentValue;
			} else {
				output -= currentValue;
			}
			previousValue = currentValue;
		}
		return output;
	}

	public static int romanToInt_1(String s) {
		int output = 0;
		int l = s.length();
		for (int i = 0; i < l; i++) {

			char ch = s.charAt(i);
			if (i != l - 1 && ch == 'I' && s.charAt(i + 1) == 'V') {
				output += 4;
				i++;
			} else if (i != l - 1 && ch == 'I' && s.charAt(i + 1) == 'X') {
				output += 9;
				i++;
			} else if (i != l - 1 && ch == 'X' && s.charAt(i + 1) == 'L') {
				output += 40;
				i++;
			} else if (i != l - 1 && ch == 'X' && s.charAt(i + 1) == 'C') {
				output += 90;
				i++;
			} else if (i != l - 1 && ch == 'C' && s.charAt(i + 1) == 'D') {
				output += 400;
				i++;
			} else if (i != l - 1 && ch == 'C' && s.charAt(i + 1) == 'M') {
				output += 900;
				i++;
			} else if (ch == 'I') {
				output += 1;
			} else if (ch == 'V') {
				output += 5;
			} else if (ch == 'X') {
				output += 10;
			} else if (ch == 'L') {
				output += 50;
			} else if (ch == 'C') {
				output += 100;
			} else if (ch == 'D') {
				output += 500;
			} else if (ch == 'M') {
				output += 1000;
			}
		}
		return output;
	}
}
