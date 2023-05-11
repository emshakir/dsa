package com.faang.me.ds.linkedlist;

import com.faang.me.ds.linkedlist.singlyLinkedList.SinglyLinkedList;

/**
 * Created By Mohammad Shakir - 03/12/2022
 */
public class $08_EvenAfterOddLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList sLL_1 = new SinglyLinkedList();
        sLL_1.add(1);
        sLL_1.add(4);
        sLL_1.add(5);
        sLL_1.add(2);
        SinglyLinkedList.Node node = sLL_1.getHeadNode();
        SinglyLinkedList.Node tempNode = getEvenAfterOdd(node);
        System.out.println("Execution Started");
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " -> ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value);
    }

    // 1 4 5 2   ------->   1 5 4 2


    /*
     * 1. Need to declare two Nodes for Odd and Even
     * 2. check odd/even for head node value, if odd add to odd node otherwise add to even node
     * 3. Make Odd's first Node as Odd head as that is what we need to return
     * 4. Make Even's first Node as Even head as that is what we need to append to Odd's last node
     * 4. Add Even Nodes head to odd's first Node.
     * 5. Return Odd Node as head.
     *
     * CORNER CASES ::::::
     * 1. Head or Head's next could be null.
     *
     * */

    public static SinglyLinkedList.Node getEvenAfterOdd(SinglyLinkedList.Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        SinglyLinkedList.Node evenHead = null, evenTail = null;
        SinglyLinkedList.Node oddHead = null, oddTail = null;

        while (head != null) {
            if (head.value % 2 == 0) {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = head;
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            head = head.next;
        }

        if (evenHead == null) {
            oddTail.next = null;
            return oddHead;
        }

        if (oddHead == null) {
            evenTail.next = null;
            return evenHead;
        }
        oddTail.next = evenHead;
        evenTail.next = null;
        return oddHead;
    }
}
