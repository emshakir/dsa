package com.faang.me.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created By Mohammad Shakir - 13/12/2022
 */
public class BinaryTreeUse {

    private static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root node: ");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeTreeInput();
        root.right = takeTreeInput();
        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int nodeData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root node: ");
        } else {
            if (isLeft) {
                System.out.println("Enter Left Child Data for " + nodeData);
            } else {
                System.out.println("Enter Right Child Data for " + nodeData);
            }
        }
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeTreeInputBetter(false, data, true);
        root.right = takeTreeInputBetter(false, data, false);
        return root;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Root Element: ");
        int input = scanner.nextInt();
        if (input == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(input);
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> currRoot = q.poll();
            System.out.println("Enter Left Child for " + currRoot.data);
            int left = scanner.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftRoot = new BinaryTreeNode<>(left);
                q.add(leftRoot);
                currRoot.left = leftRoot;
            }

            System.out.println("Enter Right Child for " + currRoot.data);
            int right = scanner.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightRoot = new BinaryTreeNode<>(right);
                q.add(rightRoot);
                currRoot.right = rightRoot;
            }
        }
        return root;
    }

    public static void printTreePreOrder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " : ");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static void printLevelWiseTreeDetailed(BinaryTreeNode<Integer> root) {

        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> currentRoot = q.poll();
            System.out.print(currentRoot.data + ":");

            BinaryTreeNode<Integer> currentRootLeft = currentRoot.left;
            if (currentRootLeft != null) {
                System.out.print("L:" + currentRootLeft.data);
                q.add(currentRootLeft);
            } else {
                System.out.print("L:-1");
            }

                BinaryTreeNode<Integer> currentRootRight = currentRoot.right;
            if (currentRootRight != null) {
                System.out.print(",R:" + currentRootRight.data);
                q.add(currentRootRight);
            } else {
                System.out.print(",R:-1");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//
//        BinaryTreeNode<Integer> left = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> right = new BinaryTreeNode<>(3);
//
//        root.left = left;
//        root.right = right;
//
//        BinaryTreeNode<Integer> twoLeft = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> threeRight = new BinaryTreeNode<>(5);
//        left.left = twoLeft;
//        right.right = threeRight;
//        BinaryTreeNode<Integer> root = takeTreeInput();
//        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWiseTreeDetailed(root);
    }
}
