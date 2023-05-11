package com.faang.me.apnacollege.binary_tree;

import com.faang.me.apnacollege.binary_tree.$09_BST;

/**
 * Created By Mohammad Shakir - 01/02/2023
 */
public class $10_PrintInRange {

  public static void printInRange(Node<Integer> root, int k1, int k2) {
    if (root == null) {
      return;
    }

    if (root.data < k1) {
      printInRange(root.left, k1, k2);
    } else if (root.data > k2) {
      printInRange(root.right, k1, k2);
    } else {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
    }
  }

  public static void main(String[] args) {
    int[] arr = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    for (int ele : arr) {
      $09_BST.insert(ele);
    }
    printInRange($09_BST.root, 1, 14);
  }
}
