package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class SecondLargestPair<T> {

    TreeNode<T> max;
    TreeNode<T> min;

    public SecondLargestPair() {
    }

    public SecondLargestPair(TreeNode<T> max, TreeNode<T> min) {
        this.max = max;
        this.min = min;
    }

}
