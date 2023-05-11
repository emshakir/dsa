package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 03/12/2022
 */
public class $10_SwapTwoNodesofLL {

    public static void main(String[] args) {
        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(1);
        sLL_1.add(2);
        sLL_1.add(4);
        sLL_1.add(5);
        sLL_1.add(6);
        sLL_1.add(7);
        sLL_1.add(9);
        SinglyLinkedList.Node head = sLL_1.getHeadNode();
        SinglyLinkedList.Node tempNode = swapNodes(head, 1, 4);
        System.out.println("Execution Started");
        while (tempNode != null && tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }

    //  1 - 2 - 6 - 3 - 4 - 5 - null
    //  i = 1 and j = 4
    //  1 - 4 - 6 - 3 - 2 - 5 - null
    private static SinglyLinkedList.Node swapNodes(SinglyLinkedList.Node head, int i, int j) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedList.Node tempNode = head;
        SinglyLinkedList.Node previous = null;
        SinglyLinkedList.Node previous1 = null, previous2 = null;
        SinglyLinkedList.Node current1 = null, current2 = null;
        int indexCounter = 0;
        while (tempNode != null) {
            if (indexCounter == i) {
                previous1 = previous;
                current1 = tempNode;
            } else if (indexCounter == j) {
                previous2 = previous;
                current2 = tempNode;
            }
            previous = tempNode;
            tempNode = tempNode.next;
            indexCounter++;
        }

        if (previous1 != null) {
            previous1.next = current2;
        } else {
            head = current2;
        }

        if (previous2 != null) {
            previous2.next = current1;
        } else {
            head = current1;
        }
        SinglyLinkedList.Node temp = current2.next;
        current2.next = current1.next;
        current1.next = temp;
        return head;
    }
}
