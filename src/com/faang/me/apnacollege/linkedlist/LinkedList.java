package com.apna_college.linkedlist;

/**
 * Created By Mohammad Shakir - 14/01/2023
 */
public class LinkedList<T> {
    private static int size;
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(20);
        ll.addFirst(10);
        ll.addLast(40);
        ll.addLast(50);
        ll.print();
//        System.out.println(ll.size());
//        ll.removeFirst();
//        ll.print();
//        System.out.println(ll.size());
//        ll.print();
//        System.out.println(ll.size());
//        ll.remove(1);
//        ll.reverse();
//        ll.print();
        System.out.println(ll.size());
    }

    public void addFirst(T data) {

        // create new node
        Node<T> newNode = new Node<>(data);
        size++;
        // if ll is null head and tail will point to new node and return
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // newNode's next will point to head
        newNode.next = head;

        // head will point to new node
        head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        size++;
        if (head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, T data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        if (idx == size - 1) {
            addLast(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        size++;
        Node<T> temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        Node<T> prev = head;
        while (prev.next.next != null) {
            prev = prev.next;
        }
        T data = prev.next.data;
        prev.next = null;
        size--;
        tail = prev;
        return data;
    }

    public T remove(int idx) {
        if (idx == 0) {
            return removeFirst();
        }

        if (idx == size - 1) {
            return removeLast();
        }

        Node<T> prev = head;
        int i = 0;
        while (i < idx - 1) {
            prev = prev.next;
            i++;
        }
        T data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");

    }

    public boolean conatins(T data) {


        Node<T> temp = head;
        while (temp != null) {
            if (temp.data == data) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int containsRec(T data) {
        return containsHelper(head, data, 0);
    }

    private int containsHelper(Node<T> node, T data, int idx) {
        if (node == null) {
            return -1;
        }

        if (node.data == data) {
            return idx;
        }
        return containsHelper(node.next, data, idx + 1);
    }

    public Node<T> getHead() {
        return head;
    }

    public void print(Node<T> head) {
        Node<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " -> ");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    public void reverse() {

        Node<T> curr = tail = head;
        Node<T> prev = null;
        Node<T> next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node<Integer> getHeadNodeInteger() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        return ll.head;
    }
}

