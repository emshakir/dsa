package com.faang.me.apnacollege.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 17/02/2023
 */
public class HashTable<K, V> {

  private List<LinkedList<Node>> bucket;

  private int no_of_nodes;
  private int size;

  public HashTable() {
    bucket = new ArrayList<>();
    no_of_nodes = 0;
    size = 5;
    for (int i = 0; i < size; i++) {
      bucket.add(new LinkedList<>());
    }
  }

  private int getBucketIndex(K key) {
    int bi = key.hashCode();
    return Math.abs(bi) % size;
  }

  private int searchInLinkedList(K key, int bi) {
    LinkedList<Node> ll = bucket.get(bi);
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
    List<LinkedList<Node>> temp = bucket;
    size = size * 2;
    no_of_nodes = 0;
    for (int i = 0; i < size; i++) {
      bucket.add(new LinkedList<>());
    }

    for (int i = 0; i < temp.size(); i++) {
      Node node = temp.get(i).remove();
      put(node.key, node.value);
    }

  }

  public void put(K key, V value) {
    int bi = getBucketIndex(key);
    int llIdx = searchInLinkedList(key, bi);

    if (llIdx != -1) {
      Node node = bucket.get(bi).get(llIdx);
      node.value = value;
      return;
    } else {
      Node newNode = new Node(key, value);
      bucket.get(bi).add(newNode);
      no_of_nodes++;
    }

    double lambda = (double) no_of_nodes / size;

    if (lambda > 2.0) {
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

