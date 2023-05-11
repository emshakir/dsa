package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;

/**
 * Created By Mohammad Shakir - 14/12/2022
 */
public class $02_SumOfNodes {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int noOfNodes = getSumOfNodes(root);
        System.out.println("Sum of Nodes: " + noOfNodes);
    }

    private static int getSumOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSumOfNodes(root.left);
        int rightSum = getSumOfNodes(root.right);
        return root.data + leftSum + rightSum;
    }
}
