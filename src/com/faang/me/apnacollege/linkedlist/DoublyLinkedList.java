package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 18/01/2023
 */
public class DoublyLinkedList<T> {

    public Node<T> head;
    public Node<T> tail;
    public int size;

    public static void main(String[] args) {

    }

    public void addFirst(T data) {

        Node<T> newNode = new Node<>(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, T data) {
        if (size == 0) {
            addFirst(data);
            return;
        }

        if (idx == size) {
            addLast(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        size++;
        int i = 1;
        Node<T> temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        Node<T> next = temp.next;
        newNode.next = next;
        newNode.prev = temp;
        temp.next = newNode;
        next.prev = newNode;
    }

    public T removeFirst() {

        if (head == null) {
            System.out.println("Linked List is Empty ::::: ");
            return null;
        }

        T data = head.data;
        if (head.next == null || size == 1) {
            head = tail = null;
            size = 0;
            return data;
        }

        head = head.next;
        head.prev = null;
        size--;
        return data;

    }

    public T removeLast() {
        if (head == null) {
            System.out.println("Linked List is Empty ::::: ");
            return null;
        }

        T data = head.data;
        if (head.next == null || size == 1) {
            head = tail = null;
            size = 0;
            return data;
        }
        T tailData = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return tailData;
    }

    public T remove(int idx) {
        if (head == null) {
            System.out.println("Linked List is emptyt ::::");
        }

        if (idx == 0) {
            return removeFirst();
        }

        if (idx == size - 1) {
            return removeLast();
        }

        int i = 1;
        Node<T> temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        T data = temp.next.data;
        temp.next = temp.next.next;
        temp = temp.prev;
        size--;
        return data;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public int size() {
        return size;
    }

    public void reverse() {
        Node<T> curr = head;
        Node<T> next = null;
        Node<T> prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public class Node<T> {

        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }
}
