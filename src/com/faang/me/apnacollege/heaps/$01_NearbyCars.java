package com.faang.me.apnacollege.heaps;

import com.faang.me.apnacollege.heaps.dto.Point;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created By Mohammad Shakir - 11/02/2023
 */
public class $01_NearbyCars {


  public static void getKNearByCars(int[][] arr, int k) {

    Queue<Point> pq = new PriorityQueue<>();

    for (int i = 0; i < arr.length; i++) {
      int distance = arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
      pq.add(new Point(distance, i));
    }

    for (int i = 0; i < k; i++) {
      System.out.println("C" + pq.remove().getPosition());
    }
  }

  public static void main(String[] args) {

    int[][] arr = {{3, 3}, {5, -1}, {-2, 4}};
    getKNearByCars(arr, 2);
  }
}
