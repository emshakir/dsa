package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 15/12/2022
 */
public class $05_NodesGreaterThanValue {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        int greaterVal = getNodesGreaterThanValue(root, 17);
        System.out.println("Node Greater Than Values :: " + greaterVal);
    }

    public static int getNodesGreaterThanValue(BinaryTreeNode<Integer> root, int x) {

        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data > x) {
            count += 1;
        }

        count += getNodesGreaterThanValue(root.left, x);
        count += getNodesGreaterThanValue(root.right, x);
        return count;
    }
}
