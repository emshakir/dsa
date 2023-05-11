package com.faang.me.ds.strings;

public class SubstringInAString {

	public static void main(String[] args) {
		String searchMe = "Green Eggs and Ham";
		String findMe = "Eggs";
		boolean found = false;
//		method1(searchMe, findMe, found);
		method2(searchMe, findMe, found);
	}

	public static void method1(String searchMe, String findMe, boolean found) {
		String[] searchMeArray = searchMe.split(" ");

		for (String element : searchMeArray) {
			if (element.equalsIgnoreCase(findMe)) {
				found = true;
				System.out.println("Found Element: " + element);
				break;
			}
		}
		if (!found) {
			System.out.println("Element Not Found");
		}
	}

	public static void method2(String searchMe, String findMe, boolean found) {
		
		// Green Eggs and Ham
		for (int i = 0; i < searchMe.length() - findMe.length(); i++) {
			System.out.println(i+":"+searchMe.charAt(i));
			if (searchMe.regionMatches(i, findMe, 0, findMe.length())) {
				found = true;
				System.out.println("Found Element: " + searchMe.substring(i, i + findMe.length()));
				break;
			}
		}
		if (!found) {
			System.out.println("Element Not Found");
		}
	}
}
