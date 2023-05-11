package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 15/01/2023
 */
public class $05_DetectCycleInLinkedList {


    public static boolean isCycle(Node<Integer> head) {
        if (head == null) {
            return false;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next = head.next.next;
        System.out.println(isCycle(head));
    }
}
