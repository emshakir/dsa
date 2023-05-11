package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 23/10/2022
 */
public class BinarySearch {


    private static int binarySearch(int[] array, int si, int ei, int element) {

        if (ei < si) {
            return -1;
        }
        int middleIndex = (si + ei) / 2;
        if (array[middleIndex] == element) {
            return middleIndex;
        } else if (array[middleIndex] < element) {
            return binarySearch(array, middleIndex + 1, ei, element);
        } else {
            return binarySearch(array, si, middleIndex - 1, element);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(array, 0, array.length - 1, 5);
        System.out.println(index);
    }
}
