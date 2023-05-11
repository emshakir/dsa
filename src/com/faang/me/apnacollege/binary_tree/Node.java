package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class Node<T> {
  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

