/*	
	You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
	Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
	Letters are case sensitive, so "a" is considered a different type of stone from "A".

	Example 1:
		Input: jewels = "aA", stones = "aAAbbbb"
		Output: 3
		
	Example 2:
		Input: jewels = "z", stones = "ZZ"
		Output: 0

*/
package com.faang.me.ds.strings;

import java.util.HashSet;
import java.util.Set;

public class $01_Jewels_Stones {

	public static void main(String[] args) {
		String jewels = "aA";
		String stones = "aAAbbbb";
		int count = numJewelsInStones(jewels, stones);
		System.out.println("COUNT:::::::: "+count);
	}

	static int numJewelsInStones(String jewels, String stones) {

		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			System.out.println("index:::::: "+jewels.indexOf(stones.charAt(i)));
			if (jewels.indexOf(stones.charAt(i)) != -1) {
				count++;
			}
		}
		return count;
	}
	
	static int numJewelsInStonesMethod_2(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int output = 0;
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        for(int i=0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                output++;
            }
        }
        return output;
    }
}
