package com.faang.me.ds.stacks;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 10/12/2022
 */
public class $03_CheckRedundantBrackets {

    public static void main(String[] args) {
        System.out.println(doesHaveRedundantBrackets("(((a)+(b)+(c)))"));
    }

    public static boolean doesHaveRedundantBrackets(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ')') {
                stack.push(ch);
            } else {
                int count = 0;
                while (stack.pop() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
