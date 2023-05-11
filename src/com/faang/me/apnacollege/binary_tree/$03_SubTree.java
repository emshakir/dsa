package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $03_SubTree {

  public static boolean isIdentical(Node<Integer> node, Node<Integer> subRoot) {

    if (node == null && subRoot == null) {
      return true;
    }
    if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    }

//    boolean isLeftIde = isIdentical(node.left, subRoot.left);
//    boolean isRightIde = isIdentical(node.right, subRoot.right);

    // This will improve the performance, according to AND rule
    // if first condition mismatches it will return false without checking for other conditions
    return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
  }

  public static boolean isSubtree(Node<Integer> root, Node<Integer> subRoot) {
    if (root == null) {
      return false;
    }

    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    Node<Integer> root = BinaryTreeUse.buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
    Node<Integer> subRoot = new Node<>(2);
    subRoot.left = new Node<>(3);
    subRoot.right = new Node<>(4);
    BinaryTreeUse.__printLevelorder(subRoot);
    System.out.println("\n");
    System.out.println(isSubtree(root, subRoot));
  }
}
