package com.faang.me.apnacollege.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class BinaryTreeUse {

  static int idx = 0;

  // Each level in single line
  public static void __printLevelorder(Node<Integer> root) {

    if (root == null) {
      return;
    }

    Queue<Node<Integer>> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      Node<Integer> curr = q.poll();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        }
        q.add(null);
        System.out.println();
      } else {
        System.out.print(curr.data + " ");
        Node<Integer> left = curr.left;
        if (left != null) {
          q.add(left);
        }

        Node<Integer> right = curr.right;
        if (right != null) {
          q.add(right);
        }
      }
    }

  }

  public static void printLevelOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }
    Queue<Node<Integer>> q = new LinkedList<>();
    System.out.print(root.data + " ");
    q.add(root);
    while (!q.isEmpty()) {
      Node<Integer> curr = q.poll();
      Node<Integer> left = curr.left;
      if (left != null) {
        q.add(left);
        System.out.print(left.data + " ");
      }

      Node<Integer> right = curr.right;
      if (right != null) {
        q.add(right);
        System.out.print(right.data + " ");
      }
    }
  }

  public static void printPostOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    printPostOrder(root.left);
    printPostOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static void printInOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }
    printInOrder(root.left);
    System.out.print(root.data + " ");
    printInOrder(root.right);

  }

  public static void printPreOrder(Node<Integer> root) {
    if (root == null) {
      return;
    }

    System.out.print(root.data + " ");
    printPreOrder(root.left);
    printPreOrder(root.right);
  }

  public static Node<Integer> buildTree(int[] arr) {

    int ele = arr[idx++];
    if (ele == -1) {
      return null;
    }

    Node<Integer> root = new Node<>(ele);
    root.left = buildTree(arr);
    root.right = buildTree(arr);
    return root;
  }


  public static Node<Integer> __buildTree(int[] arr) {
    int idx = 0;
    Queue<Node<Integer>> q = new LinkedList<>();
    Node<Integer> root = new Node<>(arr[idx++]);
    q.add(root);
    while (!q.isEmpty()) {
      Node<Integer> curr = q.poll();

      int left = arr[idx++];
      if (left != -1) {
        Node<Integer> leftNode = new Node<Integer>(left);
        q.add(leftNode);
        curr.left = leftNode;
      }

      int right = arr[idx++];
      if (right != -1) {
        Node<Integer> rightNode = new Node<Integer>(right);
        q.add(rightNode);
        curr.right = rightNode;
      }
    }
    return root;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
    Node<Integer> root = buildTree(arr);
    System.out.print("Pre order: ");
    printPreOrder(root);
    System.out.println();
    System.out.print("In order: ");
    printInOrder(root);
    System.out.println();
    System.out.print("Post order: ");
    printPostOrder(root);
    System.out.println();
    System.out.print("Level order: ");
    printLevelOrder(root);
    System.out.println();
    System.out.println("Level order, each level in single line: ");
    __printLevelorder(root);

  }
}
