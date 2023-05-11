package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 17/12/2022
 */
public class $13_MirrorBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        BinaryTreeNode<Integer> returned = mirrorBinaryTree(root);
        BinaryTreeUse.printTreeDetailed(returned);
    }

    public static BinaryTreeNode<Integer> mirrorBinaryTree(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        BinaryTreeNode<Integer> leftTemp = root.left;
        BinaryTreeNode<Integer> rightTemp = root.right;
        root.right = mirrorBinaryTree(leftTemp);
        root.left = mirrorBinaryTree(rightTemp);
        return root;
    }
}
