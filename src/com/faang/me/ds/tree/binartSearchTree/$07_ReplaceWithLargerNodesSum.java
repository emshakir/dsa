package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;
import com.faang.me.ds.tree.binartTrees.$17_TreeUsingInAndPostOrder;

/**
 * Created By Mohammad Shakir - 25/12/2022
 */
public class $07_ReplaceWithLargerNodesSum {

    public static void main(String[] args) {
        int[] inOrder = {2, 5,6,7,8,10};
        int[] postOrder = {2, 7, 6, 5, 10,8};
        BinaryTreeNode<Integer> root = $17_TreeUsingInAndPostOrder.getBinaryTree(postOrder, inOrder);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
        replaceWithLargerNodesSum(root);
        System.out.println("::::");
        BinaryTreeUse.printLevelWiseTreeDetailed(root);

    }

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        helper(root, 0);
    }

    public static int helper(BinaryTreeNode<Integer> root, int sum) {

        if (root == null) {
            return 0;
        }
        int sumOfGreaterNodes = helper(root.right, sum);
        int temp = root.data;
        root.data += sumOfGreaterNodes + sum;
        int leftSum = helper(root.left, root.data);
        return temp + leftSum + sumOfGreaterNodes;


    }
}
