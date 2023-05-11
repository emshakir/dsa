package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 23/10/2022
 */
public class QuickSort {

    private static int getPivotIndex(int[] a, int si, int ei) {

        int pivot = a[ei];
        int pivotIndex = si - 1;
        for (int i = si; i <= ei; i++) {
            if (a[i] < pivot) {
                pivotIndex++;
                int temp = a[pivotIndex];
                a[pivotIndex] = a[i];
                a[i] = temp;
            }
        }
        pivotIndex++;
        int temp = a[pivotIndex];
        a[pivotIndex] = pivot;
        a[ei] = temp;
        return pivotIndex;
    }

    private static void quickSort(int[] a, int si, int ei) {
        if (si < ei) {
            int pivotIndex = getPivotIndex(a, si, ei);
            quickSort(a, si, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, ei);
        }
    }

    public static void main(String[] args) {

        int[] a = {7, 1, 5, 3, 6, 4};
        quickSort(a, 0, a.length - 1);
    }
}
