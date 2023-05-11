package com.faang.me.ds.linkedlist.DoublyLinkedList;

/**
 * Created By Mohammad Shakir - 05/10/2022
 */
public class DoublyLinkedListTest {

    public static void main(String[] args) {

        DoublyLinkedList dLL = new DoublyLinkedList();
        dLL.add(20);
//        dLL.add(30);
//        dLL.add(1, 10);
//        dLL.add(2, 15);
//        dLL.add(5, 50);
//        dLL.add(3, 18);
        dLL.delete(1);

        System.out.println(dLL);
    }
}
