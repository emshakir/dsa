package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 17/12/2022
 */
public class $12_RemoveLeafNodes {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);
        return root;
    }
}
