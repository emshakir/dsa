package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 03/12/2022
 */
public class $09_DeleteEveryNnodes {

    public static void main(String[] args) {
        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(10);
        sLL_1.add(22);
        sLL_1.add(10);
        sLL_1.add(26);
        sLL_1.add(11);
        sLL_1.add(7);
        sLL_1.add(8);
        sLL_1.add(1);
        sLL_1.add(23);
        sLL_1.add(5);
        sLL_1.add(1);
        sLL_1.add(28);
        SinglyLinkedList.Node node = sLL_1.getHeadNode();
        SinglyLinkedList.Node tempNode = skipMdeleteN(node, 2, 3);
        System.out.println("Execution Started");
        while (tempNode != null && tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);

    }

    private static SinglyLinkedList.Node skipMdeleteN(SinglyLinkedList.Node head, int skipAfter, int toBeSkipped) {
        if (head == null) {
            return head;
        }
        int nodeCounter = 1;
        SinglyLinkedList.Node tempNode = head;
        while (tempNode != null) {
            if (nodeCounter < skipAfter) {
                tempNode = tempNode.next;
                nodeCounter++;
            } else {
                SinglyLinkedList.Node headAfterSkipping = getHeadAfterSkippingNodes(tempNode.next, toBeSkipped);
                tempNode.next = headAfterSkipping;
                tempNode = headAfterSkipping;
                nodeCounter = 1;
            }
        }
        return head;
    }

    private static SinglyLinkedList.Node getHeadAfterSkippingNodes(SinglyLinkedList.Node tempNode, int toBeSkipped) {
        int skipCounter = 1;
        while (skipCounter <= toBeSkipped && tempNode != null) {
            tempNode = tempNode.next;
            skipCounter++;
        }
        return tempNode;
    }
}
