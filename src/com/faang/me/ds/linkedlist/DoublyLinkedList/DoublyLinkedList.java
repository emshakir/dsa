package com.faang.me.ds.linkedlist.DoublyLinkedList;

/**
 * Created By Mohammad Shakir - 05/10/2022
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;


    public Node add(int element) {
        Node node = new Node();
        node.value = element;
        node.next = null;
        if (head == null) {
            node.previous = null;
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        size++;
        return node;
    }

    public void add(int index, int element) {
        if (index == 0) {
            throw new IndexOutOfBoundsException("Cannot Insert at Position " + index);
        }
        if (head == null) {
            add(element);
            return;
        }
        Node node = new Node();
        node.value = element;
        if (index == 1) {
            head.previous = node;
            node.next = head;
            node.previous = null;
            head = node;
        } else if (index > size) {
            add(element);
            return;
        } else {
            Node tempNode = getNode(index);
            node.next = tempNode.next;
            tempNode.next.previous = node;
            node.previous = tempNode;
            tempNode.next = node;
        }
        size++;
    }

    private Node getNode(int index) {
        Node tempNode = head;
        int listIndex = 1;
        while (listIndex < index - 1) {
            tempNode = tempNode.next;
            listIndex++;
        }
        return tempNode;
    }

    public boolean delete(int index) {
        if (head != null) {
            if (index == 0) {
                throw new IndexOutOfBoundsException("Cannot Insert at Position " + index);
            }
            if (index == 1) {
                if (size == 0) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.previous = null;
                }
            } else if (index >= size) {
                tail = tail.previous;
                tail.next = null;
            } else {
                Node tempNode = getNode(index);
                tempNode.next = tempNode.next.next;
                tempNode.next.previous = tempNode;
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            Node tempNode = head;
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < size; i++) {
                sb.append(tempNode.value);
                if (i != size - 1) {
                    sb.append(",");
                }
                tempNode = tempNode.next;
            }
            return sb + "]";
        }
    }

    public class Node {

        private Node next;
        private Node previous;
        private int value;
    }
}
