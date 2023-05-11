package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $02_DiameterOfTree {


  public static Diameter diameterOptimal(Node<Integer> root) {
    if (root == null) {
      Diameter d = new Diameter(0, 0);
      return d;
    }

    Diameter left = diameterOptimal(root.left);
    Diameter right = diameterOptimal(root.right);

    int height = Math.max(left.height, right.height) + 1;
    int rootDiameter = left.height + right.height + 1;
    int diameter = Math.max(rootDiameter, Math.max(left.diameter, right.diameter));
    Diameter res = new Diameter(height, diameter);
    return res;
  }

  public static int height(Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    int left = height(root.left);
    int right = height(root.right);
    return Math.max(left, right) + 1;
  }

  public static int treeDiameter(Node<Integer> root) {
    if (root == null) {
      return 0;
    }

    int leftDiameter = treeDiameter(root.left);
    int rightDiameter = treeDiameter(root.right);
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    int rootDiameter = leftHeight + rightHeight + 1;

    return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, -1, -1, 4, -1, -1, 5, -1, 6, -1, -1};
    Node<Integer> root = BinaryTreeUse.buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println();
    System.out.println("Tree Diameter naive: " + treeDiameter(root));
    Diameter res = diameterOptimal(root);
    System.out.println("Tree Diameter optimal: " + res.diameter);
  }
}
