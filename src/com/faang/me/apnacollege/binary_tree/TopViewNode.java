package com.faang.me.apnacollege.binary_tree;

/**
 * Created By Mohammad Shakir - 25/01/2023
 */
public class TopViewNode<T> {

  public Node<T> node;
  public int hd;

  public TopViewNode(Node<T> node, int hd) {
    this.node = node;
    this.hd = hd;
  }
}
