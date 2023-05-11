package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 16/01/2023
 */
public class $09_ZigZagLinkedList {

    private static Node<Integer> reverse(Node<Integer> head) {
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

    private static Node<Integer> getMid(Node<Integer> head) {
        Node<Integer> slow = head;
        Node<Integer> fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node<Integer> getZigZagLinkedList(Node<Integer> head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle(MIDDLE - first half last node)
        Node<Integer> mid = getMid(head);
        // Reverse the second half
        Node<Integer> rightHead = reverse(mid.next);
        // Alternate Merging of two lists
        Node<Integer> leftHead = head;

        Node<Integer> leftNext = null;
        Node<Integer> rightNext = null;

        while (leftHead != null && rightHead != null) {
            // ZigZaqg Merging
            leftNext = leftHead.next;
            leftHead.next = rightHead;
            rightNext = rightHead.next;
            rightHead.next = leftNext;

            //updating head nodes
            leftHead = leftNext;
            rightHead = rightNext;
        }
        return head;
    }


    public static void main(String[] args) {

    }
}
