package com.faang.me.apnacollege.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Mohammad Shakir - 12/03/2023
 */
public class $08_PairSumTo0 {


  public static int optimal(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i : arr) {
      // This is the key point for the problem to get the value for negative key and add it to sum
      if (map.containsKey(-i)) {
        count += map.get(-i);
      }
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    return count;
  }

  public static int pairSum(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(-arr[i]) && map.get(-arr[i]) > 0) {

        //this is for corner case, all array elements are 0,-(0) will be zero;
        // (n(n - 1)) / 2  to get pairs for n numbers

        if (arr[i] == -arr[i]) {
          int value = map.get(arr[i]);
          count += (value * (value - 1)) / 2;
          map.put(arr[i], 0);
          continue;
        }
        count += map.get(arr[i]) * map.get(-arr[i]);
        map.put(arr[i], 0);
        map.put(-arr[i], 0);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 0, 0};
    System.out.println(pairSum(arr));
  }
}


