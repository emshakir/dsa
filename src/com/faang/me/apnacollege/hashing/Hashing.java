package com.faang.me.apnacollege.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 12/02/2023
 */
public class Hashing {

  public static void main(String[] args) {

  }


  static class HashMap<K, V> {

    int n; // Number of nodes
    int N; // Size of Buckets
    private LinkedList<Node>[] bucket;

    public HashMap() {
      this.N = 4;
      this.n = 0;
      bucket = new LinkedList[4];

      for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new LinkedList<>();
      }
    }

    private int getBucketIndex(K key) {

      // get Hashcode for key
      int hashCode = key.hashCode();

      // make Hashcode within Bucket size
      return Math.abs(hashCode) % N;
    }

    private int searchinLL(K key, int bi) {
      LinkedList<Node> currLL = bucket[bi];
      int j = 0;
      for (int i = 0; i < currLL.size(); i++) {
        Node currNode = currLL.get(i);
        if (currNode.key == key) {
          return j;
        }
        j++;
      }
      return -1;
    }

    private void rehashing() {
      LinkedList<Node>[] temp = bucket;
      bucket = new LinkedList[2 * N];
      N = 2 * N;

      for (int i = 0; i < bucket.length; i++) {
        bucket[i] = new LinkedList<>();
      }

      for (int i = 0; i < temp.length; i++) {
        LinkedList<Node> curr = temp[i];
        Node node = curr.remove();
        put(node.key, node.value);
      }

    }

    public void put(K key, V value) {

      // get the bucket index
      int bi = getBucketIndex(key);
      // Search in Linked list
      int llIdx = searchinLL(key, bi);

      // create or update Node
      if (llIdx != -1) {
        Node node = bucket[bi].get(llIdx);
        node.value = value;
      } else {
        bucket[bi].add(new Node(key, value));
        n++;
      }

      // find threshold
      double lambda = (double) n / N;
      // rehashing
      if (lambda > 2.0) {
        rehashing();
      }
    }

    public boolean containsKey(K key) {

      int bi = getBucketIndex(key);
      int llIdx = searchinLL(key, bi);

      if (llIdx != -1) {
        return true;
      } else {
        return false;
      }
    }

    public V get(K key) {
      int bi = getBucketIndex(key);
      int llIdx = searchinLL(key, bi);
      if (llIdx != -1) {
        Node node = bucket[bi].get(llIdx);
        return node.value;
      } else {
        return null;
      }
    }

    public V remove(K key) {
      int bi = getBucketIndex(key);
      int llIdx = searchinLL(key, bi);
      if (llIdx != -1) {
        Node node = bucket[bi].remove(llIdx);
        n--;
        return node.value;
      } else {
        return null;
      }
    }

    public List<K> keySet() {
      List<K> keyList = new ArrayList<>();
      for (int i = 0; i < bucket.length; i++) {
        LinkedList<Node> ll = bucket[i];
        for (Node n : ll) {
          keyList.add(n.key);
        }
      }
      return keyList;
    }

    public boolean isEmpty() {
      return n == 0;
    }


    private class Node {
      K key;
      V value;

      public Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }


  }
}
