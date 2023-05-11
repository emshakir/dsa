package com.faang.me.ds.stacks;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 08/12/2022
 */
public class $01_BalancedBrackets {

    public static void main(String[] args) {
        String expression = "({})[()]{[()]}";
        System.out.println(isBalanced(expression));

    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            } else {
                if (ch == ')' || ch == '}' || ch== ']') {
                    char topChar = stack.pop();
                    if (topChar != '(' && topChar != '{' && topChar != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
