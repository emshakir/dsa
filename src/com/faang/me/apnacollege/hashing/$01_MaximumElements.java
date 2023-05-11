package com.apna_college.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Mohammad Shakir - 16/02/2023
 */
public class $01_MaximumElements {


  public static void getMaximumElements(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();

    for (int element : arr) {
      map.put(element, map.getOrDefault(element, 0) + 1);
    }

    for (Integer key : map.keySet()) {
      if (map.get(key) > n / 3) {
        System.out.println(key);
      }
    }
  }

  public static void main(String[] args) {

    int[] arr = {1, 3, 2, 5, 1, 3, 1, 5, 1};
    getMaximumElements(arr);
  }
}
