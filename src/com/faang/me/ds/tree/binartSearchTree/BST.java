package com.faang.me.ds.tree.binartSearchTree;

import com.faang.me.ds.tree.BinaryTreeNode;

/**
 * Created By Mohammad Shakir - 29/12/2022
 */
public class BST {

  private static BinaryTreeNode<Integer> root;
  private static int size;

  public static void main(String[] args) {
    int[] arr = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    for (int ele : arr) {
      insert(ele);
    }
    print();
    delete(4);
    print();
  }

  public static void insert(int x) {
    root = insert(root, x);
    size++;
  }

  public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> node, int x) {
    if (node == null) {
      BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(x);
      return newNode;
    }

    if (x < node.data) {
      node.left = insert(node.left, x);
    } else {
      node.right = insert(node.right, x);
    }
    return node;
  }

  private static BSTDeleteNodeReturn delete(BinaryTreeNode<Integer> node, int x) {

    if (node == null) {
      return new BSTDeleteNodeReturn(null, false);
    }

    if (x < node.data) {
      BSTDeleteNodeReturn left = delete(node.left, x);
      node.left = left.root;
      left.root = node;
      return left;
    }

    if (x > node.data) {
      BSTDeleteNodeReturn right = delete(node.right, x);
      node.right = right.root;
      right.root = node;
      return right;
    }


    // zero children
    if (node.left == null && node.right == null) {
      return new BSTDeleteNodeReturn(null, true);
    }

    // only left children
    if (node.left != null && node.right == null) {
      return new BSTDeleteNodeReturn(node.left, true);
    }

    // only right children
    if (node.left == null && node.right != null) {
      return new BSTDeleteNodeReturn(node.right, true);
    }

    int rightMin = getMinimum(node.right);
    node.data = rightMin;
    BSTDeleteNodeReturn rightReturn = delete(node.right, rightMin);
    node.right = rightReturn.root;
    return new BSTDeleteNodeReturn(node, true);
  }

  private static int getMinimum(BinaryTreeNode<Integer> root) {
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    int left = getMinimum(root.left);
    int right = getMinimum(root.right);
    return Math.min(root.data, Math.min(left, right));
  }

  public static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
    if (node == null) {
      return false;
    }

    if (node.data == x) {
      return true;
    }

    if (x < node.data) {
      return isPresentHelper(node.left, x);
    } else {
      return isPresentHelper(node.right, x);
    }
  }

  public static void printHelper(BinaryTreeNode<Integer> node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " : ");
    if (node.left != null) {
      System.out.print("L" + node.left.data + ",");
    }

    if (node.right != null) {
      System.out.print("R" + node.right.data);
    }
    System.out.println();
    printHelper(node.left);
    printHelper(node.right);
  }

  public static boolean delete(int x) {
    BSTDeleteNodeReturn output = delete(root, x);
    root = output.root;
    if (output.deleted) {
      size--;
    }
    return output.deleted;
  }

  public static boolean isPresent(int x) {
    return isPresentHelper(root, x);
  }

  public static void print() {
    printHelper(root);
  }

}
