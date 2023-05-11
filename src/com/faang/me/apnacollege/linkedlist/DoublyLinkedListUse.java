package com.apna_college.linkedlist;


/**
 * Created By Mohammad Shakir - 18/01/2023
 */
public class DoublyLinkedListUse {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.add(2, 0);
        dll.add(7, 7);
        dll.print();
        dll.reverse();
        dll.print();
        System.out.println(dll.size());
    }
}
