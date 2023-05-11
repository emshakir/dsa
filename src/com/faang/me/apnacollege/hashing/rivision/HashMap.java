package com.faang.me.apnacollege.hashing.rivision;


import java.util.LinkedList;

/**
 * Created By Mohammad Shakir - 27/02/2023
 */
public class HashMap<K, V> {

  private LinkedList<Node>[] bucket;
  private int size;
  private int nodes;

  public HashMap() {
    bucket = new LinkedList[16];
    size = 0;
    nodes = 16;
    for (int i = 0; i < nodes; i++) {
      bucket[i] = new LinkedList<>();
    }
  }

  private int getBucketIdx(K key) {
    int hashCode = key.hashCode();
    return Math.abs(hashCode) % nodes;
  }

  private int searchInLinkedList(K key, int bi) {
    LinkedList<Node> ll = bucket[bi];
    int j = 0;
    for (int i = 0; i < ll.size(); i++) {
      Node node = ll.get(i);
      if (node.key.equals(key)) {
        return j;
      }
      j++;
    }
    return -1;
  }

  private void reHashing() {
    LinkedList<Node>[] temp = bucket;
    bucket = new LinkedList[2 * nodes];
    nodes = 2 * nodes;
    size = 0;
    for (int i = 0; i < nodes; i++) {
      bucket[i] = new LinkedList<>();
    }

    for (int i = 0; i < temp.length; i++) {
      LinkedList<Node> ll = temp[i];
      for (int j = 0; j < ll.size(); j++) {
        Node node = ll.get(j);
        put(node.key, node.value);
      }
    }

  }

  public void put(K key, V value) {
    int bi = getBucketIdx(key);
    int nodeIdx = searchInLinkedList(key, bi);

    if (nodeIdx != -1) {
      Node node = bucket[bi].get(nodeIdx);
      node.value = value;
      return;
    }

    Node node = new Node(key, value);
    bucket[bi].add(node);
    size++;

    double lambda = (double) size / nodes;
    if (lambda > 0.6) {
      reHashing();
    }
  }

  class Node {
    K key;
    V value;

    public Node(K k, V v) {
      this.key = k;
      this.value = v;
    }
  }
}
