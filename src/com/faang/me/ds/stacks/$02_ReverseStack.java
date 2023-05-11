package com.faang.me.ds.stacks;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 10/12/2022
 */
public class $02_ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int[] arr = {1, 2, 3, 4};
        int i = 0;
        while (i < arr.length) {
            s1.push(arr[i++]);
        }
        Stack<Integer> returnedStack = reverseStack(s1, s2);
        while (!returnedStack.isEmpty()) {
            s1.push(returnedStack.pop());
        }
        System.out.println(s1);
    }

    public static Stack<Integer> reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.isEmpty()) {
            return null;
        }
        int temp = s1.pop();
        reverseStack(s1, s2);
        s2.push(temp);
        return s2;
    }

    public static void anotherReverseMethod(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.isEmpty()) {
            return;
        }

        int temp = s1.pop();
        anotherReverseMethod(s1, s2);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(temp);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
