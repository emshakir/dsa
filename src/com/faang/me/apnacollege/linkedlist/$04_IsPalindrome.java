package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class $04_IsPalindrome {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.getHeadNodeInteger();
        ll.print(head);
        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(Node<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node<Integer> mid = $03_FindMiddleNode.getMiddleNode(head);
        Node<Integer> left = head;
        Node<Integer> right = $01_ReverseLinkedList.reverse(mid);
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
