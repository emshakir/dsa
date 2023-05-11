package com.faang.me.ds.strings;

import java.util.Scanner;

public class CustScanner {

	static Scanner scanner = new Scanner(System.in);

	public static int nextInt() {
		return scanner.nextInt();
	}

	public static long nextLong() {
		return scanner.nextLong();
	}

	public static String nextLine() {
		return scanner.nextLine();
	}
	
	public static String next() {
		return scanner.next();
	}
	
	public static char charAt() {
		return scanner.next().charAt(0);
	}
}
