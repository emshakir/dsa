package com.faang.me.apnacollege.heaps;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 11/02/2023
 */
public class HeapSort_Desc_Min {


  public static void heapSort(int[] arr) {

    int n = arr.length;
    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, i, n);
    }

    for (int i = n - 1; i >= 0; i--) {

      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, 0, i);

    }
  }

  public static void heapify(int[] arr, int idx, int size) {

    int minIdx = idx;
    int left = (2 * idx) + 1;
    int right = (2 * idx) + 2;

    if (left < size && arr[left] < arr[minIdx]) {
      minIdx = left;
    }

    if (right < size && arr[right] < arr[minIdx]) {
      minIdx = right;
    }

    if (minIdx != idx) {
      int temp = arr[idx];
      arr[idx] = arr[minIdx];
      arr[minIdx] = temp;
      heapify(arr, minIdx, size);
    }

  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5, 3};
    heapSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
