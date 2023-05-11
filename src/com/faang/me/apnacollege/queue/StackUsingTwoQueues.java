package com.apna_college.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 24/01/2023
 */
public class StackUsingTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;

    public StackUsingTwoQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
        this.size = 0;
    }

    public static void main(String[] args) {

    }

    // Making remove and peek Operation costly
    // O(1)
    public void _add(int e) {
        q1.add(e);
        size++;
    }

    //O(N)
    public int _remove() {
        if (q1.isEmpty()) {
            return -1;
        }

        // remove last but one element from q1 and add to q2
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }

        // store last element in temp
        int temp = q1.remove();

        // swap queues as we are using q1
        Queue<Integer> q = q2;
        q2 = q1;
        q1 = q;
        return temp;
    }

    //O(N)
    public int _peek() {
        if (q1.isEmpty()) {
            return -1;
        }
        int temp = _remove();
        q1.add(temp);
        return temp;
    }


    //Making Push operation costly - O(N)
    public void add(int e) {
        q2.add(e);
        size++;
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // O(1)
    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        int data = q1.remove();
        size--;
        return data;
    }

    //O(1)
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return q1.peek();
    }


    //O(1)
    public int size() {
        return q1.size();
    }

    //O(1)
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
