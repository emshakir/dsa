package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $07_NextLargeElement {

    public static TreeNode<Integer> getNextLargeElement(TreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> res = null;
        if (root.data > x) {
            res = root;
        }

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> curr = getNextLargeElement(root.children.get(i), x);
            if (curr != null) {
                if (res == null || res.data > curr.data) {
                    res = curr;
                }
            }
        }

        return res;
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

        if (root == null) {
            return root;
        }
        int min = Integer.MAX_VALUE;
        TreeNode<Integer> minNode = null;
        for (int i = 0; i < root.children.size(); i++) {

            TreeNode<Integer> maxNode = findNextLargerNode(root.children.get(i), n);
            if (maxNode == null) {
                continue;
            }
            int max = maxNode.data;
            if (min > max) {
                min = max;
                minNode = maxNode;
            }
        }
        if (root.data > n && root.data < min) {
            return root;
        }
        return minNode;

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        TreeNode<Integer> ans = getNextLargeElement(root, 18);
        System.out.println("Next Largest Node :::: " + ans.data);
    }
}
