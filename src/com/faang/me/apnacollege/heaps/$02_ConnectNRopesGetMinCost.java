package com.faang.me.apnacollege.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 11/02/2023
 */
public class $02_ConnectNRopesGetMinCost {


  public static int getMinimumCost(int arr[]) {
    Queue<Integer> pq = new PriorityQueue<>();
    for (int e : arr) {
      pq.add(e);
    }

    int minCost = 0;
    while (pq.size() > 1) {
      int min1 = pq.remove();
      int min2 = pq.remove();
      minCost += min1 + min2;
      pq.add(min1 + min2);
    }

    return minCost;
  }

  public static void main(String[] args) {
    int[] arr = {4, 3, 4, 2, 6};
    System.out.println(getMinimumCost(arr));
  }
}
