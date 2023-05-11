package com.apna_college.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class $01_PushElementAtBottom {


    public static Stack<Integer> pushBottomNaive(Stack<Integer> s, int ele) {
        Stack<Integer> tempStack = new Stack<>();

        while (!s.isEmpty()) {
            tempStack.push(s.pop());
        }
        s.push(ele);
        while (!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
        return s;
    }

    public static Stack<Integer> pushBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return stack;
        }

        int poppedEle = stack.pop();
        Stack<Integer> newStack = pushBottom(stack, element);
        newStack.push(poppedEle);
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        Stack<Integer> ns = pushBottom(s, 4);
        while (!ns.isEmpty()) {
            System.out.print(ns.pop() + " ");
        }

    }
}
