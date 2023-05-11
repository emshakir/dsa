package com.apna_college.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class $03_ReverseStack {


    public static void pushBottom(Stack<Integer> s, int e) {
        if (s.isEmpty()) {
            s.push(e);
            return;
        }
        int temp = s.pop();
        pushBottom(s, e);
        s.push(temp);
    }

    public static void reverse(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }

        int temp = s.pop();
        reverse(s);
        pushBottom(s, temp);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
