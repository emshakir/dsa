package com.faang.me.ds.linkedlist.circularSinglyLinkedList;

import com.faang.me.ds.linkedlist.circularSinglyLinkedList.CircularSinglyLinkedList;

/**
 * Created By Mohammad Shakir - 05/10/2022
 */
public class CircularSinglyLinkedListTest {

    public static void main(String[] args) {

        CircularSinglyLinkedList cSLL = new CircularSinglyLinkedList();
        cSLL.add(10);
        cSLL.add(20);
        CircularSinglyLinkedList.Node node = cSLL.add(30);
        System.out.println(cSLL);
        System.out.println(node.getNext().getValue());
    }
}
