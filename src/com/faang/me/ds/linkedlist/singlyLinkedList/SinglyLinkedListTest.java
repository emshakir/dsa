package com.faang.me.ds.linkedlist.singlyLinkedList;


/**
 * Created By Mohammad Shakir - 02/10/2022
 */
public class SinglyLinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.add(10);
        sLL.add(5);
        sLL.add(8);
        sLL.add(3);
        sLL.add(21);
        sLL.add(0, 25);
        sLL.add(4, 20);
        System.out.println(sLL);
        boolean status = sLL.contains(100);
        System.out.println("Contains Status :::: " + status);
        boolean deleteStatusStartNode = sLL.delete(1);
        System.out.println("Delete Status :::: " + deleteStatusStartNode);
        System.out.println(sLL);
        boolean deleteStatusMiddleNode = sLL.delete(3);
        System.out.println("Delete Status :::: " + deleteStatusMiddleNode);
        System.out.println(sLL);
        boolean deleteStatusEndNode = sLL.delete(4);
        System.out.println("Delete Status :::: " + deleteStatusEndNode);
        System.out.println(sLL);
        sLL.clear();
        System.out.println(sLL);
    }
}
