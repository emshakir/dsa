package com.faang.me.ds.tree.binartSearchTree;

/**
 * Created By Mohammad Shakir - 24/12/2022
 */
public class BinaryTreeLinkedListPair<H, T> {

    private H head;
    private T tail;

    public BinaryTreeLinkedListPair(H head, T tail) {
        this.head = head;
        this.tail = tail;
    }

    public H getHead() {
        return head;
    }

    public void setHead(H head) {
        this.head = head;
    }

    public T getTail() {
        return tail;
    }

    public void setTail(T tail) {
        this.tail = tail;
    }
}
