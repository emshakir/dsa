package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 29/10/2022
 */
public class DuplicatesElementsInArray {


    public static int getDuplicateElement(int[] arr) {
        Arrays.sort(arr);

        int counter = 0;
        while (counter < arr.length - 1) {
            if (arr[counter] != arr[counter + 1]) {
                return arr[counter];
            }
            counter += 2;
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 1, 2};
        System.out.println(getDuplicateElement(array));
    }
}
