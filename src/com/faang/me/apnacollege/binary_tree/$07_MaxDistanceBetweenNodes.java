package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 26/01/2023
 */
public class $07_MaxDistanceBetweenNodes {


  public static Node<Integer> lca(Node<Integer> root, int n1, int n2) {

    if (root == null) {
      return null;
    }

    if (root.data == n1 || root.data == n2) {
      return root;
    }

    Node<Integer> left = lca(root.left, n1, n2);
    Node<Integer> right = lca(root.right, n1, n2);

    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    return root;

  }


  public static int maxOfNodes(Node<Integer> root, int n) {
    if (root == null) {
      return -1;
    }

    if (root.data == n) {
      return 0;
    }
    int left = maxOfNodes(root.left, n);
    int right = maxOfNodes(root.right, n);

    if (left == -1 && right == -1) {
      return -1;
    }
//    else if (left == -1) {
//      return right + 1;
//    } else {
//      return left + 1;
//    }
    int max = Math.max(left, right);
    return max + 1;
  }

  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1};
    Node<Integer> root = BinaryTreeUse.__buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
    int n1 = 4;
    int n2 = 5;
    Node<Integer> lca = lca(root, n1, n2);
    int left = maxOfNodes(lca, n1);
    int right = maxOfNodes(lca, n2);
    System.out.println("Maximum Distance: " + (left + right));

  }
}
