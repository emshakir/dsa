package com.apna_college.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By Mohammad Shakir - 26/02/2023
 */
public class $04_UnionOfArrays {

  // without using set if arrays are sorted
  public static void getUnion(int[] a1, int[] a2) {
    int i = 0;
    int j = 0;
    List<Integer> list = new ArrayList<>();
    while (i < a1.length && j < a2.length) {
      if (a1[i] <= a2[j]) {
        if (list.size() == 0 || list.get(list.size() - 1) != a1[i]) {
          list.add(a1[i]);
        }
        i++;
      } else if (a1[i] > a2[j]) {
        if (list.size() == 0 || list.get(list.size() - 1) != a2[j]) {
          list.add(a2[j]);
        }
        j++;
      }
    }

    while (i < a1.length) {
      if (list.size() == 0 || list.get(list.size() - 1) != a1[i]) {
        list.add(a1[i]);
      }
      i++;
    }

    while (j < a2.length) {
      if (list.size() == 0 || list.get(list.size() - 1) != a2[j]) {
        list.add(a2[i]);
      }
      j++;
    }

    System.out.println(list);
  }

  public static void getUnionWithSet(int[] a1, int[] a2) {
    Set<Integer> set = new HashSet<>();
    for (Integer element : a1) {
      set.add(element);
    }
    for (Integer element : a2) {
      set.add(element);
    }
    System.out.println(set);

  }

  public static void main(String[] args) {
    int a1[] = {0, 2, 3, 4, 5};
    int a2[] = {2, 3, 4, 4, 5};
    getUnion(a1, a2);
    getUnionWithSet(a1, a2);
  }
}
