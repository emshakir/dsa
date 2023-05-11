package com.faang.me.ds.tree.binartTrees;

import com.faang.me.ds.tree.BinaryTreeDiameter;
import com.faang.me.ds.tree.BinaryTreeNode;
import com.faang.me.ds.tree.BinaryTreeUse;


/**
 * Created By Mohammad Shakir - 18/12/2022
 */
public class $15_DiameterOfBinaryTree {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUse.takeTreeInputBetter(true, 0, false);
        BinaryTreeDiameter<Integer, Integer> count = getBinaryTreeDiameter(root);
        System.out.println(count.getDiameter());
    }

    public static BinaryTreeDiameter<Integer, Integer> getBinaryTreeDiameter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            BinaryTreeDiameter<Integer, Integer> btd = new BinaryTreeDiameter<>();
            btd.setHeight(0);
            btd.setDiameter(0);
            return btd;
        }

        BinaryTreeDiameter<Integer, Integer> left = getBinaryTreeDiameter(root.left);
        BinaryTreeDiameter<Integer, Integer> right = getBinaryTreeDiameter(root.right);
        int leftDiameter = left.getDiameter();
        int rightDiameter = right.getDiameter();
        int bth = left.getHeight() + right.getHeight();
        int btd = Math.max(leftDiameter, rightDiameter);
        int diameter = Math.max(bth, btd);
        int height = Math.max(left.getHeight(), right.getHeight()) + 1;
        BinaryTreeDiameter<Integer, Integer> res = new BinaryTreeDiameter<>();
        res.setDiameter(diameter);
        res.setHeight(bth + 1);
        return res;
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int op1 = leftHeight + rightHeight;
        int op2 = diameterOfBinaryTree(root.left);
        int op3 = diameterOfBinaryTree(root.right);
        return Math.max(op1, Math.max(op2, op3)) + 1;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right) + 1;
    }

}
