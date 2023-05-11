package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 14/12/2022
 */
public class $03_BinaryTreeTraversal {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        printBinaryTreeUsingInOrderTraversal(root);
//        printBinaryTreeUsingPreOrderTraversal(root);
        System.out.println();
        printBinaryTreeUsingPostOrderTraversal(root);
        System.out.println();
    }

    private static void printBinaryTreeUsingPreOrderTraversal(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " -> ");
        printBinaryTreeUsingPreOrderTraversal(root.left);
        printBinaryTreeUsingPreOrderTraversal(root.right);
    }

    private static void printBinaryTreeUsingPostOrderTraversal(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        printBinaryTreeUsingPostOrderTraversal(root.left);
        printBinaryTreeUsingPostOrderTraversal(root.right);
        System.out.print(root.data + " -> ");
    }

    private static void printBinaryTreeUsingInOrderTraversal(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        printBinaryTreeUsingInOrderTraversal(root.left);
        System.out.print(root.data + " -> ");
        printBinaryTreeUsingInOrderTraversal(root.right);
    }
}
