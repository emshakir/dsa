package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 07/01/2023
 */
public class $01_NumberOfNodesGreaterThanX {

    public static void main(String[] args) {

    }

    public static int getNumberOfNodesGreaterThanX(TreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.data > x) {
            count += 1;
        }

        for (int i = 0; i < root.children.size(); i++) {
            int currentNodeCount = getNumberOfNodesGreaterThanX(root.children.get(i), x);
            count += currentNodeCount;
        }

        return count;
    }
}
