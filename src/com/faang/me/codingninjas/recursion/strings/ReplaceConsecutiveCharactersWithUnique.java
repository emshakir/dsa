package com.faang.me.codingninjas.recursion.strings;

/**
 * Created By Mohammad Shakir - 23/10/2022
 */
public class ReplaceConsecutiveCharactersWithUnique {


    public static String replaceConsecutiveCharacters(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String smallOutput = replaceConsecutiveCharacters(s.substring(1));
        if (s.charAt(0) == smallOutput.charAt(0)) {
            return smallOutput;
        } else {
            return s.charAt(0) + smallOutput;
        }
    }


    public static void main(String[] args) {
        System.out.println(replaceConsecutiveCharacters("abbcccddddeeeee"));
    }
}
