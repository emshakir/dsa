package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 20/12/2022
 */
public class $18_CreateAndInsertDuplicateNode {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
        insertDuplicatesNodes(root);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
    }

    public static void insertDuplicatesNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root.data);
        BinaryTreeNode<Integer> rootLeft = root.left;
        rootLeft.left = newNode;
        newNode.left = rootLeft;
        insertDuplicatesNodes(rootLeft);
        insertDuplicatesNodes(root.right);
    }
}
