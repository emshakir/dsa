package com.apna_college.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $02_InterLeaveTwoHalvesOfQueue {


    public static void interleaveStack(Queue<Integer> q) {

        Stack<Integer> s = new Stack<>();
        int halfSize = q.size() / 2;
        // Push first half elements into the stack
        // queue:16 17 18 19 20, stack: 15(T) 14 13 12 11
        for (int i = 0; i < halfSize; i++) {
            s.push(q.poll());
        }

        // enqueue back the stack elements
        // queue: 16 17 18 19 20 15 14 13 12 11
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        // dequeue the first half elements of queue
        // and enqueue them back
        // queue: 15 14 13 12 11 16 17 18 19 20
        for (int i = 0; i < halfSize; i++) {
            q.add(q.poll());
        }

        // Again push the first half elements into the stack
        // queue: 16 17 18 19 20, stack: 11(T) 12 13 14 15
        for (int i = 0; i < halfSize; i++) {
            s.push(q.poll());
        }

        // interleave the elements of queue and stack
        // queue: 11 16 12 17 13 18 14 19 15 20
        while (!s.isEmpty()) {
            q.add(s.pop());
            q.add(q.poll());
        }


    }

    public static void interleave(Queue<Integer> q) {

        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            first.add(q.remove());
        }

        while (!first.isEmpty()) {
            q.add(first.poll());
            q.add(q.poll());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        interleave(q);
        System.out.println(q);
    }
}
