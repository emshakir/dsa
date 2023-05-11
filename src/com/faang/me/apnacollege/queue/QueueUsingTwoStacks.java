package com.apna_college.queue;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 24/01/2023
 */
public class QueueUsingTwoStacks {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int size;

    public QueueUsingTwoStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        this.size = 0;
    }

    public static void main(String[] args) {


    }

    // Method - 1

    // O(N)
    public void push(int data) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        size++;
    }

    // O(1)
    public int pop() {
        return s1.pop();
    }

    //O(1)
    public int peek() {
        return s1.peek();
    }

    // Method - 2
    // O(1)
    public void enQueue(int data) {
        s1.push(data);
    }

    //O(N) only is stack2 is empty in other case O(1)
    public int deQueue() {

        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    // O(1)
    public int _peek() {
        return s2.peek();
    }

    // Using single stack, implicit stack i.e., recursion
    public int _deQueue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty :::: ");
            return -1;
        }

        if (s1.size() == 1) {
            return s1.pop();
        }

        int temp = s1.pop();
        int top = deQueue();
        s1.push(temp);
        return top;
    }
}
