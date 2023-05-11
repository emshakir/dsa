package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 17/12/2022
 */
public class $11_NodesWithoutSibling {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int count = getNodesCountWithoutSiblings(root);
        System.out.println("Nodes count without siblings:" + count);
    }

    public static int getNodesCountWithoutSiblings(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return 1;
        }

        int left = getNodesCountWithoutSiblings(root.left);
        int right = getNodesCountWithoutSiblings(root.right);
        return left + right;
    }
}
