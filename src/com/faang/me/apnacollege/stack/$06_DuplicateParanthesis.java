package com.apna_college.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 23/01/2023
 */
public class $06_DuplicateParanthesis {


    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ')') {
                s.push(ch);
            } else {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
