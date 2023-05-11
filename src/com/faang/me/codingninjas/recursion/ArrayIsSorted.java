package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 21/10/2022
 */
public class ArrayIsSorted {

    public static void main(String[] args) {

        int[] array = {1, 2, 4, 7, 8, 9, 15};
        boolean isSorted = isSorted(array);
        boolean isSortedOptimal = isSortedOptimal(array, 0);
        System.out.println(isSorted);
        System.out.println(isSortedOptimal);
    }

    private static boolean isSorted(int[] array) {
        // base condition and corner case if array length is only one
        if (array.length == 1) {
            return true;
        }

        // Compare first element with its subsequent
        if (array[0] > array[1]) {
            return false;
        }

        // Create New Array and copy elements from 1st Index to last into new Array
        int[] newTempArray = Arrays.copyOfRange(array, 1, array.length);
        boolean isSmallArraySorted = isSorted(newTempArray);
        return isSmallArraySorted;
    }

    private static boolean isSortedOptimal(int[] array, int si) {
        if (si == array.length - 1) {
            return true;
        }
        if (array[si] > array[si + 1]) {
            return false;
        }
        return isSortedOptimal(array, si + 1);
    }
}
