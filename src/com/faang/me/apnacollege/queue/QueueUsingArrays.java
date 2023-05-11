package com.apna_college.queue;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 23/01/2023
 */
public class QueueUsingArrays {

    private int data[];
    private int rear;
    private int size;

    public QueueUsingArrays() {
        this.data = new int[5];
        this.rear = -1;
        this.size = 0;
    }

    public static void main(String[] args) {

        QueueUsingArrays q = new QueueUsingArrays();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println("Size ::: " + q.size());
        q.print();
        q.enqueue(60);
        q.enqueue(70);
        System.out.println("Size ::: " + q.size());
        q.print();
        System.out.println("Front ::: " + q.front());
        System.out.println("Rear ::: " + q.rear());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i <= rear; i++) {
            System.out.println(data[i] + " ");
        }
    }

    public void enqueue(int ele) {
        if (size == data.length) {
            System.out.println("Double capaciy initiated ::: ");
            doubleCapacity();
        }

        data[++rear] = ele;
        size++;
    }

    private void doubleCapacity() {
        data = Arrays.copyOf(data, data.length + 10);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty :::; ");
            return -1;
        }

        int temp = data[0];
        System.arraycopy(data, 1, data, 0, rear);
        rear--;
        size--;
        return temp;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue ius Empty :::; ");
            return -1;
        }
        return data[0];
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue ius Empty :::; ");
            return -1;
        }
        return data[rear];
    }

}
