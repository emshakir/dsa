package com.faang.me.ds.tree.genericTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 05/01/2023
 */
public class TreeNode<T> {

    T data;
    List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
}
