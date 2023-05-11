package com.faang.me.apnacollege.heaps;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 08/02/2023
 */
public class HeapSort_Asc_Max {


  public static void heapSort(int[] arr) {

    int n = arr.length;

    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, i, n);
    }

    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, 0, i);
    }

  }


  private static void heapify(int[] arr, int idx, int size) {

    int maxIdx = idx;
    int leftChild = 2 * idx + 1;
    int rightChild = 2 * idx + 2;

    if (leftChild < size && arr[leftChild] > arr[maxIdx]) {
      maxIdx = leftChild;
    }

    if (rightChild < size && arr[rightChild] > arr[maxIdx]) {
      maxIdx = rightChild;
    }

    if (maxIdx != idx) {
      int temp = arr[idx];
      arr[idx] = arr[maxIdx];
      arr[maxIdx] = temp;
      heapify(arr, maxIdx, size);
    }

  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5, 3};
    heapSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
