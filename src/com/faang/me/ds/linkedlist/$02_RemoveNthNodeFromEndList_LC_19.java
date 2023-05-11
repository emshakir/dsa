package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 10/10/2022
 */
public class $02_RemoveNthNodeFromEndList_LC_19 {

    public static void main(String[] args) {

        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.add(1);
        sLL.add(2);
        sLL.add(3);
        sLL.add(4);
        sLL.add(5);
        sLL.add(6);
        SinglyLinkedList.Node headNode = sLL.getNode(1);
//        SinglyLinkedList.Node newNode = removeNthNodeFromLinkedListBruteForce(headNode, 2);
        SinglyLinkedList.Node newNode = optimalApproach(headNode, 4);
        SinglyLinkedList.Node tempNode = newNode;
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);

    }

    private static SinglyLinkedList.Node removeNthNodeFromLinkedListBruteForce(SinglyLinkedList.Node headNode, int n) {

        SinglyLinkedList.Node tempNode = headNode;
        int sizeCounter = 1;
        while (tempNode.next != null) {
            ++sizeCounter;
            tempNode = tempNode.next;
        }
        tempNode = headNode;
        int nodePositionTobeIgnored = sizeCounter - n;
        if (nodePositionTobeIgnored <= 0) {
            return headNode.next;
        }
        for (int i = 1; i <= nodePositionTobeIgnored; i++) {
            tempNode = tempNode.next;
        }
        tempNode = tempNode.next.next;
        return headNode;
    }

    public static SinglyLinkedList.Node optimalApproach(SinglyLinkedList.Node headNode, int n) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        SinglyLinkedList.Node newNode = sLL.getFactoryClass();
        newNode.next = headNode;
        SinglyLinkedList.Node slowPointer = newNode;
        SinglyLinkedList.Node fastPointer = newNode;
        for (int i = 1; i <= n; ++i) {
            fastPointer = fastPointer.next;
        }

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return newNode.next;
    }


}
