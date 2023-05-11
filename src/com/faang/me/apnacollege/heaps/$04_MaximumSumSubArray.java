package com.faang.me.apnacollege.heaps;

import com.apna_college.heaps.dto.MaxSumPair;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 12/02/2023
 */
public class $04_MaximumSumSubArray {


  public static int[] maximumSubArray(int[] a, int k) {

    int[] res = new int[a.length - k + 1];
    Queue<MaxSumPair> pq = new PriorityQueue<>();
    for (int i = 0; i < k; i++) {
      pq.add(new MaxSumPair(a[i], i));
    }
    res[0] = pq.peek().val;
    for (int i = k; i < a.length; i++) {
      while (!pq.isEmpty() && pq.peek().idx < (i - k)) {
        pq.remove();
      }
      pq.add(new MaxSumPair(a[i], i));
      res[i - k + 1] = pq.peek().val;
    }
    return res;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, -1, 3, 5, 3, 6, 7};
    int[] res = maximumSubArray(a, 3);
    System.out.println(Arrays.toString(res));
  }
}
