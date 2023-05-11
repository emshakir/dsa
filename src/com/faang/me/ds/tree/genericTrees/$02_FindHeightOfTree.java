package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 07/01/2023
 */
public class $02_FindHeightOfTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        int height = getHeitghtOfTree(root);
        System.out.println("Height :: " + height);
    }

    public static int getHeitghtOfTree(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int currentNodeCount = getHeitghtOfTree(root.children.get(i));
            count = Math.max(count, currentNodeCount);
        }
        return count;
    }
}
