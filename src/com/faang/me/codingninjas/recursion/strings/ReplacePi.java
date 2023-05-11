package com.faang.me.codingninjas.recursion.strings;

/**
 * Created By Mohammad Shakir - 22/10/2022
 */
public class ReplacePi {

    public static void main(String[] args) {
        System.out.println(replacePi("p"));
    }

    private static String replacePi(String s) {

        if (s.length() <= 1) {
            return s;
        }

        // get the small output for pi and replace it with 3.14
        if (s.charAt(0) == 'p' && s.charAt(1) == 'i') {
            String smallOutput = replacePi(s.substring(2));
            return "3.14" + smallOutput;
        } else {
            String smallOutput = replacePi(s.substring(1));
            return s.charAt(0) + smallOutput;
        }
    }
}
