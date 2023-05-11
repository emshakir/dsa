package com.faang.me.ds.strings;

public class FetchIndexBasedOnChar {

	public static void main(String[] args) {
		String inputString = CustScanner.next();
		int inputChar = CustScanner.charAt();
		int num = inputString.indexOf(inputChar);
		System.out.println("Index: "+num);;		
	}
}
