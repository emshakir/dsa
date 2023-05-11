package com.faang.me.ds.strings;

public class ReplaceString {

	public static void main(String[] args) {
		String s1 = CustScanner.nextLine();

		String replaceChar = s1.replace("j", "J");
		String replaceString = s1.replace("java", "Java");
		String replaceFirst = s1.replaceFirst("java", "javaScript");
		String replaceAll = s1.replaceAll("java", "javaScript");
		
		System.out.println("\n"+replaceChar+"\n");
		System.out.println(replaceString+"\n");
		System.out.println(replaceFirst+"\n");
		System.out.println(replaceAll+"\n");

	}
}
