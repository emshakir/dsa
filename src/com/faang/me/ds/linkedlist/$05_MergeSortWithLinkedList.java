package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 27/11/2022
 */
public class $05_MergeSortWithLinkedList {

    public static void main(String[] args) {

        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(5);
        sLL_1.add(1);
        sLL_1.add(4);
        sLL_1.add(2);
        sLL_1.add(6);
        sLL_1.add(3);
        SinglyLinkedList.Node node = sLL_1.getHeadNode();
        SinglyLinkedList.Node mergedListHeadNode = mergeSort(node);
        SinglyLinkedList.Node tempNode = mergedListHeadNode;
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }

    public static SinglyLinkedList.Node mergeSort(SinglyLinkedList.Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        SinglyLinkedList.Node middleNode = getMiddleNodeOfLinkedList(head);
        SinglyLinkedList.Node list1HeadNode = head;
        SinglyLinkedList.Node list2HeadNode = middleNode.next;
        middleNode.next = null;
        SinglyLinkedList.Node newHeadNode1 = mergeSort(list1HeadNode);
        SinglyLinkedList.Node newHeadNode2 = mergeSort(list2HeadNode);
        SinglyLinkedList.Node headNode = mergeLinkedList(newHeadNode1, newHeadNode2);
        return headNode;

    }

    private static SinglyLinkedList.Node mergeLinkedList(SinglyLinkedList.Node newHeadNode1, SinglyLinkedList.Node newHeadNode2) {

        if (newHeadNode1 == null) {
            return newHeadNode2;
        }

        if (newHeadNode2 == null) {
            return newHeadNode1;
        }

        if (newHeadNode1.value > newHeadNode2.value) {
            SinglyLinkedList.Node tempNode = newHeadNode2;
            newHeadNode2 = newHeadNode1;
            newHeadNode1 = tempNode;
        }

        SinglyLinkedList.Node headNode = newHeadNode1;

        while (newHeadNode1.next != null && newHeadNode2 != null) {
            if (newHeadNode1.next.value <= newHeadNode2.value) {
                newHeadNode1 = newHeadNode1.next;
            } else {

                SinglyLinkedList.Node tempNode = newHeadNode1.next;
                newHeadNode1.next = newHeadNode2;
                newHeadNode2 = newHeadNode2.next;
                newHeadNode1.next.next = tempNode;
                newHeadNode1 = newHeadNode1.next;
            }
        }

        if (newHeadNode2 != null) {
            newHeadNode1.next = newHeadNode2;
        }

        return headNode;

    }

    private static SinglyLinkedList.Node getMiddleNodeOfLinkedList(SinglyLinkedList.Node head) {
        SinglyLinkedList.Node fastPointer = head;
        SinglyLinkedList.Node slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;

    }


}
