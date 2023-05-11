package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 25/10/2022
 */
public class StringToInteger {

    //12567

    public static int stringToInteger(String s) {
        if (s.length() == 1) {
            return Integer.parseInt(s);
        }
        int smallOutput = stringToInteger(s.substring(0, s.length() - 1));
            int lastDigit = Character.getNumericValue(s.charAt(s.length() - 1));
        return smallOutput * 10 + lastDigit;
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("00012567"));
    }
}
