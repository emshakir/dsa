package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class $03_FindMiddleNode {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.getHeadNodeInteger();
        ll.print(head);
        Node<Integer> middle = getMiddleNode(head);
        System.out.println(middle.data);
    }

    public static Node<Integer> getMiddleNode(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
