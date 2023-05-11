package com.faang.me.ds.tree.genericTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 08/01/2023
 */
public class $08_SecondLargestElement {
    public static TreeNode<Integer> getSecondLargestNodeOptimal(TreeNode<Integer> root) {
        if (root.children.size() == 0) {
            return null;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        TreeNode<Integer> max = root;
        TreeNode<Integer> secondMax = null;
        int data = 0;
        while (!q.isEmpty()) {
            TreeNode<Integer> frontNode = q.poll();
            for (int i = 0; i < root.children.size(); i++) {
                q.add(root.children.get(i));
            }

            if (frontNode.data > data) {
                if (frontNode.data > max.data) {
                    secondMax = max;
                    data = max.data;
                    max = frontNode;
                } else if (frontNode.data < max.data) {
                    secondMax = frontNode;
                    data = secondMax.data;
                }
            }
        }
        return secondMax;
    }

    public static TreeNode<Integer> getSecondLargestNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> largestNode = getLargestNode(root);
        changeMaxNodeDataToMin(root, largestNode.data);
        return getLargestNode(root);
    }

    public static void changeMaxNodeDataToMin(TreeNode<Integer> node, int max) {
        if (node == null) {
            return;
        }

        if (node.data == max) {
            node.data = Integer.MIN_VALUE;
        }

        for (int i = 0; i < node.children.size(); i++) {
            changeMaxNodeDataToMin(node.children.get(i), max);
        }
    }

    public static TreeNode<Integer> getLargestNode(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> maxNode = root;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> curr = getLargestNode(root.children.get(i));
            if (maxNode.data < curr.data) {
                maxNode = curr;
            }
        }
        return maxNode;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = GenericTreeUse.takeInputLevelWise();
        TreeNode<Integer> res = getSecondLargestNode(root);
        System.out.println(res.data);
    }
}
