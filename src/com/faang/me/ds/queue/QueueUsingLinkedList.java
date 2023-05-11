package com.faang.me.ds.queue;

import java.util.NoSuchElementException;

/**
 * Created By Mohammad Shakir - 11/12/2022
 */
public class QueueUsingLinkedList<T> {

    private T data;
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        int nodeData = (int) front.data;
        if (size == 1) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        size--;
        return nodeData;
    }

    public int front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (int) front.data;
    }

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}


