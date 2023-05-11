package com.apna_college.stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class StackUsingLinkedList {


    static Node head;
    static int size = 0;


    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public static void push(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public static int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public static int pop() {
        if (head == null) {
            return -1;
        }
        int data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public static void main(String[] args) {

        StackUsingLinkedList sll = new StackUsingLinkedList();
        sll.push(3);
        sll.push(2);
        sll.push(1);
        sll.push(0);

        while(!sll.isEmpty()) {
            System.out.println(sll.peek());

        }
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
