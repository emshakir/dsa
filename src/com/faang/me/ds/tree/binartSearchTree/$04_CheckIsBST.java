package com.faang.me.ds.tree.binartSearchTree;


import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;
import com.faang.me.ds.tree.binartTrees.$17_TreeUsingInAndPostOrder;

/**
 * Created By Mohammad Shakir - 24/12/2022
 */
public class $04_CheckIsBST {

    public static void main(String[] args) {
        int[] inOrder = {1, 2, 3, 4, 5, 6, 7};
        int[] postOrder = {1, 3, 2, 5, 7, 6, 4};
        BinaryTreeNode<Integer> root = $17_TreeUsingInAndPostOrder.getBinaryTree(postOrder, inOrder);
        boolean isBST = isBST(root);
        BinaryTreeUse.printLevelWiseTreeDetailed(root);
        System.out.println(isBST);

    }

    private static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftMaximum = maximum(root.left);
        if (leftMaximum >= root.data) {
            return false;
        }

        int rightMinimum = minimum(root.right);
        if (rightMinimum < root.data) {
            return false;
        }

        boolean left = isBST(root.left);
        boolean right = isBST(root.right);
        return left && right;
    }

    public static int minimum(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = minimum(root.left);
        int right = minimum(root.right);
        return Math.min(root.data, Math.min(left, right));
    }

    public static int maximum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maximum(root.left);
        int right = maximum(root.right);
        return Math.max(root.data, Math.max(left, right));
    }

    public static boolean isBSTOptimised(BinaryTreeNode<Integer> root) {
        BinaryTreeMaxMin<Integer, Integer> result = getBinaryTreeNodeMaxMin(root);
        return result.isBST();
    }

    public static BinaryTreeMaxMin<Integer, Integer> getBinaryTreeNodeMaxMin(BinaryTreeNode<Integer> root) {

        if (root == null) {
            BinaryTreeMaxMin<Integer, Integer> bst = new BinaryTreeMaxMin<>(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return bst;
        }

        BinaryTreeMaxMin<Integer, Integer> left = getBinaryTreeNodeMaxMin(root.left);
        BinaryTreeMaxMin<Integer, Integer> right = getBinaryTreeNodeMaxMin(root.right);

        int minimum = Math.min(root.data, Math.max(left.getMin(), right.getMin()));
        int maximum = Math.max(root.data, Math.max(left.getMax(), right.getMax()));
        boolean isBst = true;

        if (left.getMax() >= root.data || right.getMin() < root.data) {
            isBst = false;
        }

        if (!left.isBST() || !right.isBST()) {
            isBst = false;
        }

        BinaryTreeMaxMin<Integer, Integer> res = new BinaryTreeMaxMin<>(minimum, maximum, isBst);
        return res;
    }



    public static boolean isBSTAnother(BinaryTreeNode<Integer> root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        boolean left = isBSTAnother(root.left, min, root.data - 1);
        boolean right = isBSTAnother(root.right, root.data, max);
        return left && right;
    }
}
