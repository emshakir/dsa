package com.faang.me.ds.linkedlist.singlyLinkedList;

/**
 * Created By Mohammad Shakir - 02/10/2022
 */
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

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

    /**
     * While Adding the Node in the Linked List,
     * 1. The linked list may be null, So need to add new node as a first
     * 2. If exist then we need to add node as next node, which would be at the end
     * and as we are using tail it would be easy for us to add node at the end using tail reference
     *
     * @param value
     * @return
     */
    public Node add(int value) {
        Node node = new Node();
        node.next = null;
        node.value = value;
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

    /**
     * While Adding node at specific position there can be possibly three chances,
     * <p>
     * 1. The Linked may be empty, so it may be the first node of linked list, add node point head and tail to new node
     * 2. Node may be first node of Linked list, here we should move the reference of to head to new node.next
     * and head will point to new node
     * 3. Node may be the last Node of Linked List, here we have the tail node which have last reference so
     * tail.next will be new node and tail will point at new node
     * 4. Node may be in between of the Linked List, here we need to iterate till last but one position of the specified
     * node store the next node of temp node in some node(Node nextNode = tempNode.next) and
     * then in(tempNode.next = node) then finally (node.next = nextNode) to continue the Linked list relationship.
     *
     * @param location
     * @param value
     */
    public void add(int location, int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            add(value);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location == size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = getNode(location);
            // took backup and assigned the value
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
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

    /**
     * Here I may have two possibilities
     * 1. There may be more than one element in the singly list(if so just remove the reference of first and
     * point its next reference to head).
     * 2. There can be only a single element which could be known when size is 0
     * (if so already head will pointing to null just make tail as null)
     * <p>
     * 3. To delete the last element we have to iterate till the last but one node and make its next as null
     * which will remove the refernce to the last element and them assign the last but one node to tail
     * <p>
     * 4. To remove the element from middle iterate till the last but one element of element to remove
     * then make its next's next element to current node which will remove the reference to current node
     */
    public boolean delete(int index) {

        if (index == 0 || index > size) {
            throw new IndexOutOfBoundsException("No Element at " + index);
        }
        if (head != null) {
            if (index == 1) {
                head = head.next;
                size--;
                if (size == 0) {
                    tail = null;
                }
            } else if (index >= size) {
                Node tempNode = getNode(index);
                tempNode.next = null;
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

    public Node getNode(int index) {
        Node tempNode = head;
        int listindex = 1;
        while (listindex < index - 1) {
            tempNode = tempNode.next;
            listindex++;
        }
        return tempNode;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    public Node getFactoryClass() {
        return new Node();
    }

    public Node getHeadNode() {
        return head;
    }

    public class Node {
        public int value;
        public Node next;
    }
}
