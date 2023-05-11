package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 03/12/2022
 */
public class $07_FindNodeRecursive {

    public static void main(String[] args) {
        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(100);
        sLL_1.add(200);
        sLL_1.add(300);
        sLL_1.add(400);
        sLL_1.add(9000);
        sLL_1.add(-34);
        SinglyLinkedList.Node node = sLL_1.getHeadNode();
        int nodeIndexPosition = findNodeRecursive(node, -34);
        System.out.println("Node Index position ::::: " + nodeIndexPosition);
    }

    private static int findNodeRecursive(SinglyLinkedList.Node head, int nodeData) {
        return findNodeRecursive(head, nodeData, 0);
    }

    private static int findNodeRecursive(SinglyLinkedList.Node head, int nodeData, int currentNodeIndex) {
        //base condition

        if (head == null) {
            return -1;
        }

        if (head.value == nodeData) {
            return currentNodeIndex;
        }
        return findNodeRecursive(head.next, nodeData, currentNodeIndex + 1);
    }
}
