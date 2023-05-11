package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 21/10/2022
 */
public class CheckNumberInArray {

    public static void main(String[] args) {
        int[] array = {4, 5, 7, 8, 6, 1, 3, 9};
        int number = 9;
        boolean result = checkNumber(array, number);
        System.out.println(result);
        boolean hasNumberOptimal = hasNumberOptimal(array, number, 0);
        System.out.println(hasNumberOptimal);
    }

    public static boolean checkNumber(int input[], int x) {
        // if array has single element, this will be help full for our base case
        if (input.length == 1) {
            return input[0] == x ? true : false;
        }
        if (input[0] == x) {
            return true;
        } else {
            int[] newArray = Arrays.copyOfRange(input, 1, input.length);
            return checkNumber(newArray, x);
        }
    }

    private static boolean hasNumberOptimal(int[] input, int x, int si) {
        if (si == input.length) {
            return false;
        }
        if (input[si] == x) {
            return true;
        }
        return hasNumberOptimal(input, x, si + 1);
    }
}
