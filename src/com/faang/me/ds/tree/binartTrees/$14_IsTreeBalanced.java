package com.faang.tree.binartTrees;

import com.faang.me.ds.tree.BalancedTreeReturn;
import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 17/12/2022
 */
public class $14_IsTreeBalanced {

    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        boolean isBalanced = isBalanced(root);
        System.out.println("Is Balanced:" + isBalanced);
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeightOfTree(root.left);
        int rightHeight = getHeightOfTree(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);
        return isLeftBalanced && isRightBalanced;
    }

    private static int getHeightOfTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = getHeightOfTree(root.left);
        int right = getHeightOfTree(root.right);
        return 1 + Math.max(left, right);
    }

    public static BalancedTreeReturn isBalancedOptimal(BinaryTreeNode<Integer> root) {

        if (root == null) {
            BalancedTreeReturn bal = new BalancedTreeReturn();
            bal.setHeight(0);
            bal.setIsbalanced(true);
            return bal;
        }

        BalancedTreeReturn left = isBalancedOptimal(root.left);
        BalancedTreeReturn right = isBalancedOptimal(root.right);
        int height = 1 + Math.max(left.getHeight(), right.getHeight());
        boolean isBalanced = true;

        if (Math.abs(left.getHeight() - right.getHeight()) > 1) {
            isBalanced = false;
        }

        if (!left.isIsbalanced() || !right.isIsbalanced()) {
            isBalanced = false;
        }

        BalancedTreeReturn result = new BalancedTreeReturn();
        result.setHeight(height);
        result.setIsbalanced(isBalanced);
        return result;
    }
}
