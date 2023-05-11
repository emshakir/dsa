package com.apna_college.queue;

/**
 * Created By Mohammad Shakir - 24/01/2023
 */
public class QueueUsingLinkedList<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public static void main(String[] args) {

    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        size++;
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty :::");
            return null;
        }

        T temp = front.data;
        if (size == 1) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty :::");
            return null;
        }
        return front.data;
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
