package com.faang.me.ds.stacks;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 10/12/2022
 */
public class $05_MinimumBracketReversal {

    public static void main(String[] args) {
        String expression = "}{{{";
        System.out.println(countBracketReversal(expression));
    }

    public static int countBracketReversal(String exp) {

        if (exp.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '{') {
                stack.push(ch);
            } else if (ch == '}') {
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        int count = 0;
        while (!stack.isEmpty()) {
            char ch1 = stack.pop();
            char ch2 = stack.pop();

            if (ch1 == ch2) {
                count = count + 1;
            } else {
                count = count + 2;
            }
        }
        return count;
    }
}
