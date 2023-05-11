package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 23/10/2022
 */
public class MergeSort {

    public static void conquer(int[] a, int si, int mi, int ei) {

        int[] tempArray = new int[ei - si + 1];
        int index1 = si;
        int index2 = mi + 1;
        int counter = 0;
        while (index1 <= mi && index2 <= ei) {
            if (a[index1] <= a[index2]) {
                tempArray[counter++] = a[index1++];
            } else {
                tempArray[counter++] = a[index2++];
            }
        }

        while (index1 <= mi) {
            tempArray[counter++] = a[index1++];
        }

        while (index2 <= ei) {
            tempArray[counter++] = a[index2++];
        }

        for (int i = 0, j = si; i < tempArray.length; i++, j++) {
            a[j] = tempArray[i];
        }
    }


    public static void divide(int[] a, int si, int ei) {
        if (ei > si) {
            int middleIndex = (si + ei) / 2;
            divide(a, si, middleIndex);
            divide(a, middleIndex + 1, ei);
            conquer(a, si, middleIndex, ei);
        }
    }

    public static void main(String[] args) {

        int array[] = {6, 3, 9, 5, 2, 8};
        divide(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
