package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 15/01/2023
 */
public class $06_RemoveCycleFromLinkedList {

    public static void removeCycle(Node<Integer> head) {
        if (head == null || head.next == null) {
            return;
        }

        Node<Integer> fast = head;
        Node<Integer> slow = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return;
        }

        slow = head;
        //NOTE: This will be null if cycle forms at head, will throw NullPointerException
        Node<Integer> prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null; // This will remove the cycle
    }

    public static void removeCycleOther(Node<Integer> head) {

        boolean isCycle = false;
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow){
                isCycle = true;
                break;
            }
        }

        if(isCycle){
            slow = head;
            while(slow != fast){
                fast = fast.next;
                slow =slow.next;
            }

            while(fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    //KV46t8p-mN88x5hfYJlEug

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = new Node<Integer>(1);
        head.next = new Node<>(2);
        head.next.next = new Node<>(3);
        head.next.next.next = new Node<>(4);
        head.next.next.next.next = new Node<>(5);
        head.next.next.next.next.next = head.next.next;
        removeCycleOther(head);
        ll.print(head);
    }
}
