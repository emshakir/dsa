/*
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:

'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.

 

Example 1:

Input: words = ["gin","zen","gig","msg"]
Output: 2
Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".
Example 2:

Input: words = ["a"]
Output: 1
*/

package com.faang.me.ds.strings;

import java.util.HashSet;
import java.util.Set;

public class $07_UniqueMorseRepresentations {

	public static void main(String[] args) {

//		String[] words = { "gin", "zen", "gig", "msg" };
		String[] words = {"a"};
		System.out.println(uniqueMorseRepresentations(words));
	}

	static int uniqueMorseRepresentations(String[] words) {

		Set<String> set = new HashSet<String>();
		String alp[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

		for (String word : words) {
			String morseWord = "";
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				System.out.println(ch - 'a');
				System.out.println("MORSE WORD::::::::" + alp[ch - 'a']);
				morseWord += alp[ch - 'a'];
			}
			System.out.println("CONCATINATED WORD:::::::" + morseWord);
			set.add(morseWord);
		}
		return set.size();
	}
}
