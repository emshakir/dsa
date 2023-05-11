package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
