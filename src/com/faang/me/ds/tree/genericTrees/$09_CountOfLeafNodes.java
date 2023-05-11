package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $09_CountOfLeafNodes {

    public static int countLeafNodes(TreeNode<Integer> root) {

        // Write your code here

        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.children.size() == 0) {
            count++;
        }

        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
