package com.faang.me.codingninjas.recursion.strings;

/**
 * Created By Mohammad Shakir - 22/10/2022
 */
public class ReplaceChar {


    public static void main(String[] args) {
        System.out.println(replaceChar("abcxcxcxhs", 'x', 'y'));
        System.out.println(replaceStringOptimal("abcxcxcxhs", 'x', 'y', 0));
    }

    private static String replaceChar(String input, char original, char toBeReplaced) {

        if (input.length() == 0) {
            return input;
        }
        String smallOutput = replaceChar(input.substring(1), original, toBeReplaced);

        if (input.charAt(0) == original) {
            return toBeReplaced + smallOutput;
        } else {
            return input.charAt(0) + smallOutput;
        }
    }

    private static String replaceStringOptimal(String s, char original, char toBeReplaced, int si) {

        if (si == s.length()) {
            return "";
        }

        String smallOutput = replaceStringOptimal(s, original, toBeReplaced, si + 1);
        if (s.charAt(si) == original) {
            return toBeReplaced + smallOutput;
        } else {
            return s.charAt(si) + smallOutput;
        }
    }
}
