package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 15/12/2022
 */
public class $07_LeafNodesOfBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int leafNodes = getLeafNodesOfBinaryTree(root);
        System.out.println(leafNodes);
    }


    public static int getLeafNodesOfBinaryTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodesOfBinaryTree(root.left) + getLeafNodesOfBinaryTree(root.right);
    }
}
