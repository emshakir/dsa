package com.faang.me.apnacollege.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 08/02/2023
 */
public class MaximumHeap {

  private List<Integer> list;

  public MaximumHeap() {
    list = new ArrayList<>();
  }

  public static void main(String[] args) {
    MaximumHeap pq = new MaximumHeap();
    pq.add(10);
    pq.add(9);
    pq.add(8);
    pq.add(7);
    pq.add(6);
    pq.add(5);
    pq.add(4);
    while (!pq.isEmpty()) {
      System.out.println(pq.delete());
    }
  }


  public void add(int data) {
    // add data to array
    list.add(data);

    // find parent's position using child
    int child = list.size() - 1;
    int parent = (child - 1) / 2;

    //swap child with parent if condition matches
    while (list.get(child) > list.get(parent)) {
      int temp = list.get(child);
      list.set(child, list.get(parent));
      list.set(parent, temp);

      child = parent;
      parent = (child - 1) / 2;
    }
  }

  public int delete() {
    int lastPos = list.size() - 1;
    int data = list.get(0);
    // swap first element with last
    int temp = list.get(0);
    list.set(0, list.get(lastPos));
    list.set(lastPos, temp);

    // delete the last element
    list.remove(lastPos);

    // Fix the heap
    heapify(0);
    return data;
  }

  private void heapify(int idx) {
    int maxIdx = idx;

    // Find the left and right childrens
    int leftChild = (2 * idx) + 1;
    int rightChild = (2 * idx) + 2;

    int listSize = list.size() - 1;

    if (leftChild < listSize && list.get(leftChild) > list.get(maxIdx)) {
      maxIdx = leftChild;
    }

    if (rightChild < listSize && list.get(rightChild) > list.get(maxIdx)) {
      maxIdx = rightChild;
    }

    if (idx != maxIdx) {

      int temp = list.get(idx);
      list.set(idx, list.get(maxIdx));
      list.set(maxIdx, temp);
      heapify(maxIdx);
    }
  }

  public int peek() {
    return list.get(0);
  }

  public boolean isEmpty() {
    return list.size() == 0;
  }
}
