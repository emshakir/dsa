package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 25/10/2022
 */
public class PairStar {

    public static String addStars(String s) {
        // Write your code here
        if (s.length() == 1) {
            return s;
        }

        String smallOutput = addStars(s.substring(1));
        if (smallOutput.charAt(0) == s.charAt(0)) {
            return s.charAt(0) + "*" + smallOutput;
        } else {
            return s.charAt(0) + smallOutput;
        }
    }

    public static void main(String[] args) {
        System.out.println(addStars("shakir"));
    }
}
