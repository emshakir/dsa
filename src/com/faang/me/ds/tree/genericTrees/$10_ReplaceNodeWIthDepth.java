package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $10_ReplaceNodeWIthDepth {


    public static void replaceNodeWithDepth(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        replaceNodeWithDepthHelper(root, 0);
    }

    public static void replaceNodeWithDepthHelper(TreeNode<Integer> root, int k) {

        for (int i = 0; i < root.children.size(); i++) {
            replaceNodeWithDepthHelper(root.children.get(i), k + 1);
        }
        root.data = k;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        replaceNodeWithDepth(root);
        GenericTreeUse.printLevelWiseOptimal(root);
    }
}
