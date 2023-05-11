package com.faang.me.apnacollege.binary_tree;


/**
 * Created By Mohammad Shakir - 30/01/2023
 */
public class $09_BST {

  public static Node<Integer> root;
  private static int size = 0;

  public static void insert(int data) {
    root = insertHelper(root, data);
    size++;
  }

  public static Node<Integer> insertHelper(Node<Integer> node, int data) {
    if (node == null) {
      Node<Integer> root = new Node<>(data);
      return root;
    }

    if (data < node.data) {
      node.left = insertHelper(node.left, data);
    } else {
      node.right = insertHelper(node.right, data);
    }
    return node;
  }

  public static int delete(int data) {
    return delete(root, data).data;
  }

  public static Node<Integer> delete(Node<Integer> node, int data) {

    if (node == null) {
      return null;
    }

    if (data < node.data) {
      node.left = delete(node.left, data);
    } else if (data > node.data) {
      node.right = delete(node.right, data);
    } else {
      if (node.left == null && node.right == null) {
        return null;
      }

      if (node.left == null) {
        return node.right;
      }

      if (node.right == null) {
        return node.left;
      }

      int newNode = getMinimum(node.right);
      node.data = newNode;
      node.right = delete(node.right, newNode);
    }


    return node;
  }

  public static int getMinimum(Node<Integer> node) {
    Node<Integer> temp = node;
    while (temp.left != null) {
      temp = temp.left;
    }
    return temp.data;
  }

  public static boolean search(int data) {
    return isPresent(root, data);
  }

  public static boolean isPresent(Node<Integer> root, int data) {
    if (root == null) {
      return false;
    }

    if (root.data == data) {
      return true;
    }

    if (root.data > data) {
      return isPresent(root.left, data);
    } else {
      return isPresent(root.right, data);
    }
  }

  public static void print() {
    printHelper(root);
  }

  public static void printHelper(Node<Integer> node) {
    if (node == null) {
      return;
    }
    printHelper(node.left);
    System.out.print(node.data + " ");
    printHelper(node.right);
  }

  public static void main(String[] args) {
    int[] arr = {8, 5, 3, 1, 4, 6, 10, 11, 14};
    for (int ele : arr) {
      insert(ele);
    }
    print();
    delete(4);
    System.out.println();
    print();

  }
}
