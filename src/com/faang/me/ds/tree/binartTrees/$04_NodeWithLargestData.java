package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 14/12/2022
 */
public class $04_NodeWithLargestData {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int largest = getLargestNodeData(root);
        System.out.println("Largest Node data :: " + largest);
    }

    public static int getLargestNodeData(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int leftLargest = getLargestNodeData(root.left);
        int rightLargest = getLargestNodeData(root.right);
        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }
}
