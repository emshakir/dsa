package com.faang.me.ds.stacks;

/**
 * Created By Mohammad Shakir - 04/12/2022
 */
public class StackUsingLinkedListTestClass {

    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack);
    }
}
