/*
 
 	You are given coordinates, a string that represents the coordinates of a square of the chessboard. Below is a chessboard for your reference.

	ref: https://leetcode.com/problems/determine-color-of-a-chessboard-square/
	
	Return true if the square is white, and false if the square is black.

	The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.
	
			Example 1:
						
					Input: coordinates = "a1"
					Output: false
					Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.
					
			Example 2:
			
					Input: coordinates = "h3"
					Output: true
					Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.
					
			Example 3:
			
					Input: coordinates = "c7"
					Output: false
			  
 */

package com.faang.me.ds.strings;

public class $13_DetermineColorOfChessboardSquare {

	public static void main(String[] args) {
		String coordinates = "a1";
		System.out.println(squareIsWhite(coordinates));
	}

	static public boolean squareIsWhite(String coordinates) {

		System.out.println('a'-'a');
		System.out.println((int)'a');
		System.out.println((int)'0');
		System.out.println('a'-'0');
		System.out.println();
		System.out.println((int)'1');
		System.out.println((int)'0');
		System.out.println('1'-'0');
		return true;
	}

}
