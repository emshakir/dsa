package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 07/01/2023
 */
public class $04_CheckIfContainsX {

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        boolean isPresent = doesContainX(root, 30);
        System.out.println("Is Present:: " + isPresent);
    }

    public static boolean doesContainXBetter(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }

        for (int i = 0; i < root.children.size(); i++) {
            if (doesContainX(root.children.get(i), x)) {
                return true;
            }
        }
        return false;
    }

    public static boolean doesContainX(TreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }

        boolean isPresent = false;
        if (root.data == x) {
            isPresent = true;
        }

        for (int i = 0; i < root.children.size(); i++) {
            boolean isPresentC = doesContainX(root.children.get(i), x);
            isPresent = isPresent || isPresentC;
        }

        return isPresent;
    }
}
