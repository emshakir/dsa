package com.faang.me.ds.stacks;

/**
 * Created By Mohammad Shakir - 04/12/2022
 */
public class StackUsingArraysTestClass {

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        for (int element : arr) {
            stack.push(element);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        System.out.println("\nstack size:" + stack.size());
    }
}
