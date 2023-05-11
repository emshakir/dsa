package com.faang.me.ds.tree;

/**
 * Created By Mohammad Shakir - 13/12/2022
 */
public class BinaryTreeNode<T> {

    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

}
