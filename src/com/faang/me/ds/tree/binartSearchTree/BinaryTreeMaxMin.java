package com.faang.me.ds.tree.binartSearchTree;

/**
 * Created By Mohammad Shakir - 24/12/2022
 */
public class BinaryTreeMaxMin<MAX, MIN> {
    private MIN min;
    private MAX max;
    private boolean isBST;

    public BinaryTreeMaxMin() {
    }

    public BinaryTreeMaxMin(MIN min, MAX max, boolean isBST) {
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }

    public boolean isBST() {
        return isBST;
    }

    public void setBST(boolean BST) {
        isBST = BST;
    }

    public MAX getMax() {
        return max;
    }

    public void setMax(MAX max) {
        this.max = max;
    }

    public MIN getMin() {
        return min;
    }

    public void setMin(MIN min) {
        this.min = min;
    }
}
