package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $06_IsTreeIdentical {


    public static boolean areTreesIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }
        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        for (int i = 0; i < root1.children.size(); i++) {

            if (!areTreesIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {

    }
}
