package com.faang.me.ds.tree.genericTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created By Mohammad Shakir - 07/01/2023
 */
public class GenericTreeUse {


    public static void printLevelWiseOptimal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        System.out.println(root.data);
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode<Integer> front = q.poll();
            if (front == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                System.out.println();
            } else {
                for (int i = 0; i < front.children.size(); i++) {
                    TreeNode<Integer> curr = front.children.get(i);
                    q.add(curr);
                    System.out.print(curr.data + " ");
                }
            }
        }
    }

    public static void printTreeLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> frontNode = q.poll();
            System.out.print(frontNode.data + " : ");
            for (int i = 0; i < frontNode.children.size(); i++) {
                TreeNode<Integer> curr = frontNode.children.get(i);
                System.out.print(curr.data + " ");
                q.add(curr);
            }
            System.out.println();
        }
    }

    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Root data : ");
        int rootData = s.nextInt();

        TreeNode<Integer> root = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode<Integer> currNode = q.poll();
            System.out.println("Enter Number of childrens for " + currNode.data + " : ");
            int numberOfChilds = s.nextInt();
            for (int i = 1; i <= numberOfChilds; i++) {
                System.out.println("Enter " + i + " child data for " + currNode.data + " : ");
                int currNodeData = s.nextInt();
                TreeNode<Integer> newNode = new TreeNode<>(currNodeData);
                currNode.children.add(newNode);
                q.add(newNode);
            }
        }
        return root;
    }

    public static TreeNode<Integer> takeInputRecursively(boolean isRoot) {
        Scanner s = new Scanner(System.in);
        if (isRoot) {
            System.out.print("Enter root data : ");
        }
        int nodeData = s.nextInt();
        System.out.print("Enter number of children for " + nodeData + " : ");
        TreeNode<Integer> root = new TreeNode<>(nodeData);
        int numOfChildrens = s.nextInt();
        for (int i = 1; i <= numOfChildrens; i++) {
            System.out.print("Enter " + i + " child Data for " + nodeData + " : ");
            TreeNode<Integer> currNode = takeInputRecursively(false);
            root.children.add(currNode);
        }
        return root;
    }


    public static int sumOfAllNodes(TreeNode<Integer> root) {

        if (root == null) {
            return 0;
        }

        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int currentRootSum = sumOfAllNodes(root.children.get(i));
            sum += currentRootSum;
        }
        return sum;
    }

    public static int numberOfNodes(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int nodeCount = numberOfNodes(root.children.get(i));
            count += nodeCount;
        }
        return count;
    }

    public static void printTree(TreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> childNode = root.children.get(i);
            printTree(childNode);
        }
    }

    public static void printTreeDetailed(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();

        for (int i = 0; i < root.children.size(); i++) {
            printTreeDetailed(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(4);
        TreeNode<Integer> node1 = new TreeNode(2);
        TreeNode<Integer> node2 = new TreeNode(3);
        TreeNode<Integer> node3 = new TreeNode(1);
        TreeNode<Integer> node4 = new TreeNode(5);
        TreeNode<Integer> node5 = new TreeNode(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);
//        printTreeDetailed(root);
//        System.out.println("Number of nodes ::: " + numberOfNodes(root));
//        System.out.println("Sum of nodes ::: " + sumOfAllNodes(root));
//        TreeNode<Integer> newRoot = takeInputRecursively(true);
//        printTreeDetailed(newRoot);
        TreeNode<Integer> newRoot = takeInputLevelWise();
        printTreeDetailed(newRoot);
        System.out.println();
        printLevelWiseOptimal(newRoot);
    }
}
