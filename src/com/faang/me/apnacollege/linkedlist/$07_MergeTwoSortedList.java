package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 15/01/2023
 */
public class $07_MergeTwoSortedList {


    // TIME COMPLEXITY - O(N)
    // SPACE COMPLEXITY - O(1)
    public static Node<Integer> mergeTwoSorteddListAnother(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.data > l2.data) {
            Node<Integer> temp = l2;
            l2 = l1;
            l1 = temp;
        }

        Node<Integer> head = l1;
        while (l1.next != null && l2 != null) {
            if (l1.next.data <= l2.data) {
                l1 = l1.next;
            } else {
                Node<Integer> temp = l1.next;
                l1.next = l2;
                l2 = l2.next;
                l1.next.next = temp;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            l1.next = l2;
        }

        return head;

    }

    // TIME COMPLEXITY - O(N)
    // SPACE COMPLEXITY - O(1)
    public static Node<Integer> mergeTwoSortedListInPlace(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        Node<Integer> head, tail = null;

        if (l1.data < l2.data) {
            head = tail = l1;
            l1 = l1.next;
        } else {
            head = tail = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        }

        if (l2 != null) {
            tail.next = l2;
        }

        return head;
    }

    // TIME COMPLEXITY - O(N)
    // SPACE COMPLEXITY - O(N)
    // --> we can do it in place with out using extra new node
    public static Node<Integer> mergeSortedLists(Node<Integer> l1, Node<Integer> l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // New node which will store sorted list head
        Node<Integer> head = new Node<>(-1);

        // Pointer to move to next nodes
        Node<Integer> pointer = head;

        // comparision of two lists and placing them in correct position
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        // pointing rest of nodes from list 1
        if (l1 != null) {
            pointer.next = l1;
        }

        // pointing  rest of nodes from list 2
        if (l2 != null) {
            pointer.next = l2;
        }

        return head.next;

    }

    public static void main(String[] args) {

    }
}
