package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 12/10/2022
 */
public class $03_MiddleOfTheLinkedList_LC_876 {

    public static void main(String[] args) {

        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.add(1);
        sLL.add(2);
        sLL.add(3);
        sLL.add(4);
        sLL.add(5);
        sLL.add(6);
        SinglyLinkedList.Node headNode = sLL.getHeadNode();
//        SinglyLinkedList.Node newNode = getMiddleNodeOfList(headNode);
        SinglyLinkedList.Node newNode = getMiddleNodeOfListOptimalSolution(headNode);
        SinglyLinkedList.Node tempNode = newNode;
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);

    }

    private static SinglyLinkedList.Node getMiddleNodeOfList(SinglyLinkedList.Node headNode) {
        int linkedListSize = 1;
        while (headNode.next != null) {
            linkedListSize++;
        }
        int nodeToBeRemoved = linkedListSize / 2;
        SinglyLinkedList.Node tempNode = headNode;
        for (int i = 1; i <= nodeToBeRemoved; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    private static SinglyLinkedList.Node getMiddleNodeOfListOptimalSolution(SinglyLinkedList.Node headNode) {
        SinglyLinkedList.Node fast = headNode;
        SinglyLinkedList.Node slow = headNode;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
