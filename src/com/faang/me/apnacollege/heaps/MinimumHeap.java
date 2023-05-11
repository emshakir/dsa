package com.faang.me.apnacollege.heaps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Mohammad Shakir - 05/02/2023
 */
public class MinimumHeap {

  public static List<Integer> heaps;

  public MinimumHeap() {
    this.heaps = new ArrayList<>();
  }

  public static void add(int element) {
    heaps.add(element);
    int c = heaps.size() - 1;  // child's index
    int p = (c - 1) / 2; //parent's index

    while (heaps.get(c) < heaps.get(p)) {
      int temp = heaps.get(c);
      heaps.set(c, heaps.get(p));
      heaps.set(p, temp);

      c = p;
      p = (c - 1) / 2;
    }
  }

  public static int peek() {
    return heaps.get(0);
  }

  public static int remove() {
    int data = heaps.get(0);

    // step1: swap first with last
    heaps.set(0, heaps.get(heaps.size() - 1));
    heaps.set(heaps.size() - 1, data);

    // step2: delete last element
    heaps.remove(heaps.size() - 1);

    // fix the heap
    heapify(0);
    return data;
  }

  private static void heapify(int i) {
    int minIdx = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < heaps.size() - 1 && heaps.get(minIdx) > heaps.get(left)) {
      minIdx = left;
    }

    if (right < heaps.size() - 1 && heaps.get(minIdx) > heaps.get(right)) {
      minIdx = right;
    }

    if (minIdx != i) {
      int temp = heaps.get(i);
      heaps.set(1, heaps.get(minIdx));
      heaps.set(minIdx, temp);

      heapify(minIdx);
    }
  }

  public static void main(String[] args) {

  }
}
