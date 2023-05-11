package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 16/12/2022
 */
public class $09_ReplaceNodeWithDepth {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        replaceNodeDataWithDepth(root, 0);
        BinaryTreeUse.printTreeDetailed(root);
    }

    public static void replaceNodeDataWithDepth(BinaryTreeNode<Integer> root, int k) {

        if (root == null) {
            return;
        }
        replaceNodeDataWithDepth(root.left, k + 1);
        replaceNodeDataWithDepth(root.right, k + 1);
        root.data = k;
    }
}
