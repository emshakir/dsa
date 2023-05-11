package com.faang.me.ds.linkedlist;

/**
 * Created By Mohammad Shakir - 30/11/2022
 */
public class $06_PalindromeLinkedList {

    public static void main(String[] args) {

    }

    /*
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode<Integer> secondHead = slow.next;
        slow.next = null;
        secondHead = reverseLinkedList(secondHead);

        LinkedListNode<Integer> firstSubList = secondHead;
        LinkedListNode<Integer> secondSubList = head;

        while (firstSubList != null) {
            if (firstSubList.data != secondSubList.data) {
                return false;
            }
            firstSubList = firstSubList.next;
            secondSubList = secondSubList.next;
        }
        firstSubList = head;
        secondSubList = reverseLinkedList(secondHead);

        while (firstSubList.next != null) {
            firstSubList = firstSubList.next;
        }

        firstSubList.next = secondSubList;
        return true;
    }

    private static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> secondHead) {
        inkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }*/
}
