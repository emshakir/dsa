package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $01_HeightOfTree {


  public static int sumOfNodes(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    int left = sumOfNodes(root.left);
    int right = sumOfNodes(root.right);
    return root.data + left + right;
  }

  public static int countOfNodes(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    int left = countOfNodes(root.left);
    int right = countOfNodes(root.right);
    return 1 + left + right;

  }

  public static int heightOfTree(Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    int left = heightOfTree(root.left);
    int right = heightOfTree(root.right);
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, -1, -1, 4, 5, -1, -1, -1, 6, 7, 9, 10, -1, -1, -1, -1, 8, -1, -1};
    Node<Integer> root = BinaryTreeUse.buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println();
    System.out.println("height of tree: " + heightOfTree(root));
    System.out.println();
    System.out.println("Number of nodes: " + countOfNodes(root));
    System.out.println();
    System.out.println("Sum of nodes: " + sumOfNodes(root));
  }
}
