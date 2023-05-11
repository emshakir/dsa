package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 28/10/2022
 */
public class IntersectionOfTwoArraysUsingBinarySearch {

    public static void intersectionOfArrayUsingBinarySearch(int[] sortedArray, int[] unSortedArray) {

        for (int i = 0; i < unSortedArray.length; i++) {
            int returnedResult = binarySearch(sortedArray, 0, sortedArray.length - 1, unSortedArray[i]);
            if(returnedResult != -1) {
                System.out.print(sortedArray[returnedResult] + " ");
            }
        }
    }

    private static int binarySearch(int[] array, int si, int ei, int element) {
        if (si > ei) {
            return -1;
        }

        int middleIndex = (si + ei) / 2;
        if (array[middleIndex] == element) {
            return middleIndex;
        } else if (array[middleIndex] > element) {
            return binarySearch(array, si, middleIndex - 1, element);
        } else {
            return binarySearch(array, middleIndex + 1, ei, element);
        }
    }

    public static void main(String[] args) {
        int[] a1 = {6, 9, 8, 5};
        int[] a2 = {9, 2, 4, 1, 8};

        if (a1.length < a2.length) {
            Arrays.sort(a1);
            intersectionOfArrayUsingBinarySearch(a1, a2);
        } else {
            Arrays.sort(a2);
            intersectionOfArrayUsingBinarySearch(a2, a1);
        }
    }
}
