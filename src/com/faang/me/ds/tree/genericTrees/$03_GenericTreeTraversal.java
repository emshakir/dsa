package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 07/01/2023
 */
public class $03_GenericTreeTraversal {


    public static void preOrderTraversal(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preOrderTraversal(root.children.get(i));
        }
    }

    public static void postOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < root.children.size(); i++) {
            postOrderTraversal(root.children.get(i));
        }

        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
    }
}
