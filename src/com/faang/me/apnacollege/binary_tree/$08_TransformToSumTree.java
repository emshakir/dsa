package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 28/01/2023
 */
public class $08_TransformToSumTree {


  public static int transformToSum(Node<Integer> root) {
    if (root == null) {
      return 0;
    }
    int left = transformToSum(root.left);
    int right = transformToSum(root.right);
    int sum = root.data + left + right;
    root.data = left + right;
    return sum;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};
    Node<Integer> root = BinaryTreeUse.__buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
    transformToSum(root);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
  }
}
