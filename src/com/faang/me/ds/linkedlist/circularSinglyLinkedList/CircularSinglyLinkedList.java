package com.faang.me.ds.linkedlist.circularSinglyLinkedList;

/**
 * Created By Mohammad Shakir - 04/10/2022
 */
public class CircularSinglyLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;


    public Node add(int element) {
        Node node = new Node();
        node.value = element;
        node.next = node;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return node;
    }

    public void add(int index, int element) {
        Node node = new Node();
        node.setValue(element);
        if (head == null) {
            node.setNext(node);
            head = node;
            tail = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
            tail.next = node;
        } else if (index >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node tempNode = getNode(index);
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
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

    public boolean contains(int element) {
        if (head != null) {
            Node tempNode = head;
            int index = 0;
            while (index < size) {
                if (tempNode.value == element) {
                    return true;
                }
                tempNode = tempNode.next;
                index++;
            }
        }
        return false;
    }

    public boolean delete(int index) {
        if (index == 0) {
            throw new IndexOutOfBoundsException("No element present at Position " + index);
        }
        if (head != null) {
            if (index == 1) {
                head = head.next;
                tail.next = head;
                size--;
                if (size == 0) {
                    head = null;
                    tail = null;
                }
            } else if (index >= size) {
                Node tempNode = getNode(index);
                tempNode.next = head;
                tail = tempNode;
                size--;
            } else {
                Node tempNode = getNode(index);
                tempNode.next = tempNode.next.next;
                size--;
            }
            return true;
        }

        return false;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder("[");
            Node tempNode = head;
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
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
