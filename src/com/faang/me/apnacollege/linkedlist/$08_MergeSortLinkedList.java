package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 15/01/2023
 */
public class $08_MergeSortLinkedList {

    public static Node<Integer> getMiddleNode(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> slow = head;
        Node<Integer> fast = head.next; // head.next as we need to get last element of first half in even condition
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }
        // get Middle node
        Node<Integer> mid = getMiddleNode(head);
        Node<Integer> right = mid.next;
        Node<Integer> left = head;
        mid.next = null;
        Node<Integer> l1 = mergeSort(left);
        Node<Integer> l2 = mergeSort(right);
        Node<Integer> sortedList = mergeTwoSortedList(l1, l2);
        return sortedList;
    }

    private static Node<Integer> mergeTwoSortedList(Node<Integer> l1, Node<Integer> l2) {
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

    public static void main(String[] args) {

    }
}
