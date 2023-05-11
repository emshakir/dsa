package com.faang.me.apnacollege.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $05_PrintKthLevel {

  public static void __printKthLevel(Node<Integer> root, int k) {

    if (root == null) {
      return;
    }

    if (k == 1) {
      System.out.print(root.data + " ");
      return;
    }
    __printKthLevel(root.left, k - 1);
    __printKthLevel(root.right, k - 1);
  }

  public static void printKthLevel(Node<Integer> root, int k) {

    if (root == null) {
      return;
    }

    Queue<Node<Integer>> q = new LinkedList<>();
    q.add(root);
    q.add(null);
    int count = 1;
    while (!q.isEmpty()) {
      Node<Integer> curr = q.poll();
      if (curr == null) {
        if (q.isEmpty()) {
          break;
        }
        q.add(null);
        count++;
      } else {
        if (count == k) {
          System.out.print(curr.data + " ");
        }
        if (curr.left != null) {
          q.add(curr.left);
        }

        if (curr.right != null) {
          q.add(curr.right);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
    Node<Integer> root = BinaryTreeUse.buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
    printKthLevel(root, 3);
    System.out.println();
    __printKthLevel(root, 3);
  }
}
