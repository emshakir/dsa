package com.faang.me.ds.stacks;

/**
 * Created By Mohammad Shakir - 04/12/2022
 */
public class StackUsingLinkedList<T> {

    private Node<T> head;
    private int size;

    public StackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(T data) {
        Node<T> tempNode = new Node<>(data);
        if (head == null) {
            head = tempNode;
        } else {
            tempNode.next = head;
            head = tempNode;
        }
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new StackEmptyException("stack is empty.");
        } else {
            return head.data;
        }
    }

    public T pop() {
        if (head == null) {
            throw new StackEmptyException("stack is Empty");
        }
        T tempNode = head.data;
        head.next = head;
        size--;
        return tempNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> tempNode = head;
        Node<T> newNode = null;
        while (tempNode != null) {
            Node<T> temp = tempNode.next;
            tempNode.next = newNode;
            newNode = head;
            head = temp;
        }
        tempNode = head;
        while (size > 1 && tempNode.next != null) {
            sb.append(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        sb.append(tempNode.data);
        return sb + "]";
    }
}
