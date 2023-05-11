package com.faang.me.apnacollege.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 26/01/2023
 */
public class $06_LowestCommonAncestor {


  public static Node<Integer> __lca(Node<Integer> root, int n1, int n2) {
    if (root == null) {
      return root;
    }

    if (root.data == n1 || root.data == n2) {
      return root;
    }

    Node<Integer> left = __lca(root.left, n1, n2);
    Node<Integer> right = __lca(root.right, n1, n2);

    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    return root;
  }


  public static boolean getPaths(Node<Integer> root, int n, List<Node<Integer>> p) {
    if (root == null) {
      return false;
    }

    p.add(root);
    if (root.data == n) {
      return true;
    }

    boolean left = getPaths(root.left, n, p);
    boolean right = getPaths(root.right, n, p);

    if (left || right) {
      return true;
    }

    p.remove(p.size() - 1);
    return false;
  }

  public static int lca(Node<Integer> root, int n1, int n2) {
    List<Node<Integer>> p1 = new ArrayList<>();
    List<Node<Integer>> p2 = new ArrayList<>();

    getPaths(root, n1, p1);
    getPaths(root, n2, p2);

    int i = 0;
    for (; i < p1.size() && i < p2.size(); i++) {
      if (p1.get(1) != p2.get(i)) {
        break;
      }
    }

    return p1.get(p1.size() - 1).data;
  }

  public static void main(String[] args) {

  }
}
