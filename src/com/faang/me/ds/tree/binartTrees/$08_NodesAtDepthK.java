package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 16/12/2022
 */
public class $08_NodesAtDepthK {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        printNodesAtDepthK(root, 2);
    }

    public static void printNodesAtDepthK(BinaryTreeNode<Integer> root, int k) {

        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.print(root.data);
            return;
        }
        printNodesAtDepthK(root.left, k - 1);
        printNodesAtDepthK(root.right, k - 1);
    }


}
