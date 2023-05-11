package com.apna_college.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 23/01/2023
 */
public class $05_ValidParanthesis {

    public static boolean isValid(String str) {

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {

                if (s.isEmpty()) {
                    return false;
                }

                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("({[{}{}{}]})"));
    }
}
