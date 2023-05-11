package com.faang.me.apnacollege.heaps;

import com.apna_college.heaps.dto.Row;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 12/02/2023
 */
public class $03_WeakestSoldiersRow {


  public static void weakestSoldier(int[][] arr, int k) {

    Queue<Row> pq = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {

      int count = 0;
      for (int j = 0; j < arr[i].length; j++) {
        count += (arr[i][j] == 1) ? 1 : 0;
      }
      pq.add(new Row(count, i));
    }

    for (int i = 0; i < k; i++) {
      System.out.println("R" + pq.remove().getIndex());
    }
  }

  public static void main(String[] args) {

    int[][] arr = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};

    weakestSoldier(arr, 2);
  }
}
