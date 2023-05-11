package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class $01_ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.getHeadNodeInteger();
        ll.print(head);
        Node<Integer> newNode = reverse(head);
        ll.print(newNode);
    }

    public static Node<Integer> reverse(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
