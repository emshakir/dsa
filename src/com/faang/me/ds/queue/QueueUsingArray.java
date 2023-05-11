package com.faang.me.ds.queue;

import java.util.NoSuchElementException;

/**
 * Created By Mohammad Shakir - 11/12/2022
 */
public class QueueUsingArray {

    private int[] data;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray() {
        this.data = new int[5];
        this.front = -1;
        this.rear = -1;
    }

    public QueueUsingArray(int defaultCapacity) {
        this.data = new int[defaultCapacity];
        this.front = -1;
        this.rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {

        if (size == data.length) {
            doubleCapacity();
        }

        if (isEmpty()) {
            front = 0;
            rear = -1;
        }

        // when queue has a room for element but the rear position same as array length may throw ArrayIndexOutOfBoundsException
//        rear++;
//        if (rear == data.length) {
//            rear = 0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = element;
        size++;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[data.length * 2];
        int index = 0;
        for (int i = front; i < temp.length; i++) {
            data[index++] = temp[i];
        }

        for (int i = rear; i >= 0; i--) {
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }

    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        } else {
            return data[front];
        }
    }

    public int rear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        } else {
            return data[rear];
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        } else {
            // when we are trying to delete element which is at array length may throw ArrayIndexOutOfBoundsException
//            front++;
//            if (front == data.length) {
//                front = 0;
//            }
            front = front + 1 % data.length;
            int temp = data[front];
            size--;
            return temp;
        }
    }
}
