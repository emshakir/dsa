package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 13/10/2022
 */
public class $04_MergeTwoSortedLists_LC_21 {

    public static void main(String[] args) {

        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(1);
        sLL_1.add(2);
        sLL_1.add(4);
        SinglyLinkedList sLL_2 = new SinglyLinkedList();
        sLL_2.add(1);
        sLL_2.add(3);
        sLL_2.add(4);
        SinglyLinkedList.Node node1 = sLL_1.getHeadNode();
        SinglyLinkedList.Node node2 = sLL_2.getHeadNode();
        SinglyLinkedList.Node mergedListHeadNode = getMergedLinkedList(node1, node2);
        SinglyLinkedList.Node tempNode = mergedListHeadNode;
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }

    private static SinglyLinkedList.Node getMergedLinkedList(SinglyLinkedList.Node list1, SinglyLinkedList.Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // create new Node
        SinglyLinkedList.Node head = new SinglyLinkedList().getFactoryClass();

        SinglyLinkedList.Node currentPointer = head;
        while (list1 != null && list2 != null) {
            int list1Val = list1.value;
            int list2Val = list2.value;
            if (list1Val <= list2Val) {
                currentPointer.next = list1;
                list1 = list1.next;
            } else {
                currentPointer.next = list2;
                list2 = list2.next;
            }
            currentPointer = currentPointer.next;
        }

        if (list1 != null) {
            currentPointer.next = list1;
        } else if (list2 != null) {
            currentPointer.next = list2;
        }
        return head.next;
    }

    public SinglyLinkedList.Node mergeTwoLists(SinglyLinkedList.Node list1, SinglyLinkedList.Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.value > list2.value) {
            SinglyLinkedList.Node temp = list2;
            list2 = list1;
            list1 = temp;
        }
        SinglyLinkedList.Node head = list1;
        while (list1.next != null && list2 != null) {
            if (list1.next.value <= list2.value) {
                list1 = list1.next;
            } else {
                SinglyLinkedList.Node temp = list1.next;
                list1.next = list2;
                list2 = list2.next;
                list1.next.next = temp;
                list1 = list1.next;
            }
        }
        if (list2 != null) {
            list1.next = list2;
        }
        return head;

    }

    public SinglyLinkedList.Node mergeTwoListsAnother(SinglyLinkedList.Node list1, SinglyLinkedList.Node list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        SinglyLinkedList.Node newHead = null, newTail = null;

        if (list1.value < list2.value) {
            newHead = list1;
            newTail = list1;
            list1 = list1.next;

        } else {
            newHead = list2;
            newTail = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                newTail.next = list1;
                list1 = list1.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
            }

            newTail = newTail.next;
        }

        if (list1 == null) {
            newTail.next = list2;
        }

        if (list2 == null) {
            newTail.next = list1;
        }

        return newHead;
    }

}
