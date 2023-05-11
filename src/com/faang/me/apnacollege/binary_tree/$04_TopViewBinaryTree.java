package com.faang.me.apnacollege.binary_tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class $04_TopViewBinaryTree {


  public static void topView(Node<Integer> root) {
    if (root == null) {
      return;
    }

    int min = 0, max = 0;
    Map<Integer, Node<Integer>> map = new HashMap<>();
    Queue<TopViewNode<Integer>> q = new LinkedList<>();
    q.add(new TopViewNode<>(root, 0));

    while (!q.isEmpty()) {
      TopViewNode<Integer> curr = q.poll();
      if (!map.containsKey(curr.hd)) {
        map.put(curr.hd, curr.node);
      }

      if (curr.node.left != null) {
        q.add(new TopViewNode<>(curr.node.left, curr.hd - 1));
        min = Math.min(min, curr.hd - 1);
      }

      if (curr.node.right != null) {
        q.add(new TopViewNode<>(curr.node.right, curr.hd + 1));
        max = Math.max(max, curr.hd + 1);
      }
    }

    for (int i = min; i <= max; i++) {
      System.out.print(map.get(i).data + " ");
    }

  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, -1};
    Node<Integer> root = BinaryTreeUse.buildTree(arr);
    BinaryTreeUse.__printLevelorder(root);
    System.out.println("\n--------");
    topView(root);
  }
}
