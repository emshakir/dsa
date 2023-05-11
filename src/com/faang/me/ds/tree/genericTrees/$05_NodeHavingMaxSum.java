package com.faang.me.ds.tree.genericTrees;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $05_NodeHavingMaxSum {

    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        TreeNode<Integer> ans = maxSumNodeOptimal(root);
        System.out.println("Max Sum Node ::::: " + ans.data);
    }


    public static TreeNode<Integer> maxSumNodeOptimal(TreeNode<Integer> root) {
        MaxSumNodePair res = maxSumHelper(root);
        return res.node;
    }

    public static MaxSumNodePair maxSumHelper(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        int maxSum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            maxSum += root.children.get(i).data;
        }
        MaxSumNodePair res = new MaxSumNodePair(root, maxSum);

        for (int i = 0; i < root.children.size(); i++) {
                MaxSumNodePair currPair = maxSumHelper(root.children.get(i));
            if (currPair.maxSum > res.maxSum) {
                res.node = currPair.node;
                res.maxSum = currPair.maxSum;
            }
        }
        return res;

    }


    /*
     *   Time complexity is O(n^2) use of nested for loops -----
     *
     * */

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        TreeNode<Integer> maxSumNode = root;
        int maxSum = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> curr = root.children.get(i);
            maxSum += curr.data;
        }

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> currNode = maxSumNode(root.children.get(i));
            int currMaxSum = currNode.data;

            for (int j = 0; j < currNode.children.size(); j++) {
                TreeNode<Integer> curr = currNode.children.get(j);
                currMaxSum += curr.data;
            }

            if (currMaxSum > maxSum) {
                maxSum = currMaxSum;
                maxSumNode = currNode;
            }
        }

        return maxSumNode;
    }
}
