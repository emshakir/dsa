package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;


/**
 * Created By Mohammad Shakir - 30/12/2022
 */
public class BSTDeleteNodeReturn {

    BinaryTreeNode<Integer> root;
    boolean deleted;

    public BSTDeleteNodeReturn(BinaryTreeNode<Integer> root, boolean deleted) {
        this.root = root;
        this.deleted = deleted;
    }
}
