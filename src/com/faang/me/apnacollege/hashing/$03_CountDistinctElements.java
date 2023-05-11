package com.apna_college.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Mohammad Shakir - 26/02/2023
 */
public class $03_CountDistinctElements {


  public static int getDistinctElements(int[] arr) {

    Set<Integer> set = new HashSet<>();
    for (int e : arr) {
      set.add(e);
    }

    return set.size();
  }

  public static void main(String[] args) {

  }
}
