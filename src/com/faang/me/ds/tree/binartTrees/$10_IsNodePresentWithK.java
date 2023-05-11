package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;


/**
 * Created By Mohammad Shakir - 17/12/2022
 */
public class $10_IsNodePresentWithK {

    public static void main(String[] args) {

    }

    public static boolean isNodePresentWithK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }

        if (root.data.equals(k)) {
            return true;
        }

        boolean left = isNodePresentWithK(root, k);
        boolean right = isNodePresentWithK(root, k);
        return left || right;
    }
}
