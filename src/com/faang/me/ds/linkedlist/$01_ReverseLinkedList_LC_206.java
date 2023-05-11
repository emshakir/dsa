package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 10/10/2022
 */
public class $01_ReverseLinkedList_LC_206 {

    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.add(6);
        sLL.add(8);
        sLL.add(10);
        sLL.add(15);
        sLL.add(20);
        SinglyLinkedList.Node headNode = sLL.getNode(1);
        SinglyLinkedList.Node newNode = reverseLinkedListRecursive(headNode);

        SinglyLinkedList.Node tempNode = newNode;
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }

    private static SinglyLinkedList.Node reverseLinkedList(SinglyLinkedList.Node headNode) {
        SinglyLinkedList.Node newNode = null;
        while (headNode != null) {
            SinglyLinkedList.Node tempNode = headNode.next;
            headNode.next = newNode;
            newNode = headNode;
            headNode = tempNode;
        }
        return newNode;
    }

    private static SinglyLinkedList.Node reverseLinkedListRecursive(SinglyLinkedList.Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedList.Node smallNode = reverseLinkedListRecursive(head.next);
        SinglyLinkedList.Node tempNode = smallNode;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = head;
        head.next = null;
        return smallNode;
    }


}
