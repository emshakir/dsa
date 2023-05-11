package com.faang.me.ds.strings;

public class IndexOfMethod {

	public static void main(String[] args) {

		String s1 = "Java Web based enterprice applicationj";
		char charEntered = 'J';
		int occurance = 1;
		if (s1.indexOf(charEntered) == -1) {
			System.out.println(charEntered + " is not Present");
		} else {
			int index = s1.indexOf(charEntered); // index = 6
			int count = 1;
			while (true) {
				if (count == occurance) {
					System.out.println(charEntered+"'s " + occurance + " occurance index is: " + index);
					break;
				}
				index = s1.indexOf(charEntered, index + 1);
				count++;
				if (index == -1) {
					System.out.println(charEntered+"'s "+occurance+" occurance not present");
					break;
				}
			}
		}
	}
}
