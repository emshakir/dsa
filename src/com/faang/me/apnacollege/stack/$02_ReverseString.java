package com.apna_college.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class $02_ReverseString {

    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverse("push"));
    }
}
