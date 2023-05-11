package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 24/10/2022
 */
public class IsPalindrome {

    public static String isPalindrome(String s) {

        if (s.length() <= 0) {
            return "";
        }
        String smallOutput = isPalindrome(s.substring(1));
        return smallOutput + s.charAt(0);
    }

    public static void main(String[] args) {
        String input = "NINJA";
        String output = isPalindrome(input);
        if (input.equalsIgnoreCase(output)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("No");
        }
    }
}
