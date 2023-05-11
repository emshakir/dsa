package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;

/**
 * Created By Mohammad Shakir - 14/12/2022
 */
public class $01_NumberOfNodes {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int noOfNodes = getNumberOfNodes(root);
        System.out.println("Number of Nodes: " + noOfNodes);
    }

    public static int getNumberOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftNodes = getNumberOfNodes(root.left);
        int rightNodes = getNumberOfNodes(root.right);
        return 1 + leftNodes + rightNodes;
    }
}
