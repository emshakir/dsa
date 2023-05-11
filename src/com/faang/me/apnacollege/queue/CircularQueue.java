package com.apna_college.queue;

/**
 * Created By Mohammad Shakir - 23/01/2023
 */
public class CircularQueue {

    private int[] data;
    private int size;
    private int front;
    private int rear;

    public CircularQueue() {
        this.data = new int[5];
        this.size = 0;
        this.front = -1;
        this.rear = -1;
    }

    public static void main(String[] args) {

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty :::: ");
            return -1;
        }

        int temp = data[front];
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    public void enque(int e) {

        if (size == data.length) {
            doubleCapacity();
        }

        if (isEmpty()) {
            front = 0;
            rear = -1;
        }
        rear = (rear + 1) % data.length;
        data[rear] = e;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
