package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 15/12/2022
 */
public class $06_HeightOfBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int greaterVal = getHeightOfBinaryTree(root);
        System.out.println("Node Greater Than Values :: " + greaterVal);
    }

    private static int getHeightOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeightOfBinaryTree(root.left);
        int rightHeight = getHeightOfBinaryTree(root.right);
        if (leftHeight > rightHeight) {
            return 1 + leftHeight;
        } else {
            return 1 + rightHeight;
        }
    }
}
