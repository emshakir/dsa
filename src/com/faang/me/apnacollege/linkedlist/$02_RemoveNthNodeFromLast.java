package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class $02_RemoveNthNodeFromLast {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.getHeadNodeInteger();
        ll.print(head);
        Node<Integer> newNode = removeNthNodeFromLastOptimal(head, 4);
        ll.print(newNode);
    }


    // Time complexity - O(N)
    // Space complexity - O(1)
    public static Node<Integer> removeNthNodeFromLast(Node<Integer> head, int n) {

        int size = 0;
        Node<Integer> temp = head;

        // find size
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // CORNER CASE: List may have only one element
        if (size == n) {
            head = head.next;
            return head;
        }

        // find previous of nth node
        int i = 1;
        int nodeTorenmove = size - n;
        Node<Integer> prev = head;
        while (i < nodeTorenmove) {
            prev = prev.next;
            i++;
        }

        // point prev's next to prev next's next
        prev.next = prev.next.next;
        return head;
    }

    public static Node<Integer> removeNthNodeFromLastOptimal(Node<Integer> head, int n) {
//        Node<Integer> newNode = new Node<>(0);
//        newNode.next = head;
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        int i = 1;
        while (i <= n) {
            fast = fast.next;
            i++;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
//        return newNode.next;
        return head;
    }
}
