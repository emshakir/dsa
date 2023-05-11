package com.apna_college.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Mohammad Shakir - 12/03/2023
 */
public class $07_MaximumFrequencyNumber {


  public static int maxFrequencyNumber(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    int res = 0;
    int max = Integer.MIN_VALUE;
    for (Integer key : map.keySet()) {
      int val = map.get(key);
      if (val > max) {
        max = val;
        res = key;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {2, 12, 2, 11, 12, 2, 1, 2, 2, 11, 12, 2, 6};
    System.out.println(maxFrequencyNumber(arr));
  }
}
