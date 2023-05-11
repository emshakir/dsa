package com.faang.me.codingninjas.heaps;

import java.util.Arrays;

/**
 *
 * @author SHAKIR
 */
public class HeapSortMin {

    public static void main(String[] args) {
        int[] array = {10, 5, 11, 2, 3, 7, 12, 1, 6};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    // heapSort for Ascending order
    private static void heapSort(int[] a) {
        int n = a.length;
        // Create Max heap for unsorted array(We use Max Heap for Ascending order)
        for (int i = (n / 2) - 1; i >= 0; i--) {
            fixHeap(a, i, n);
        }

        // sort the array
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            fixHeap(a, 0, i);
        }
    }

    private static void fixHeap(int a[], int index, int size) {

        int leftIdx = (2 * index) + 1;
        int rightIdx = (2 * index) + 2;

        while (leftIdx < size) {
            int max = index;
            if (leftIdx < size && a[leftIdx] > a[max]) {
                max = leftIdx;
            }

            if (rightIdx < size && a[rightIdx] > a[max]) {
                max = rightIdx;
            }

            if (max == index) {
                break;
            }

            int temp = a[index];
            a[index] = a[max];
            a[max] = temp;

            index = max;
            leftIdx = (2 * max) + 1;
            rightIdx = (2 * max) + 2;
        }

    }
    // Fix the heap
}
