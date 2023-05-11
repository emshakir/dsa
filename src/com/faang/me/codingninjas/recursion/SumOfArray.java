package com.faang.me.codingninjas.recursion;

import java.util.Arrays;

/**
 * Created By Mohammad Shakir - 21/10/2022
 */
public class SumOfArray {

    public static void main(String[] args) {
        int[] array = {9, 8, 9};
        int sum = sum(array);
        System.out.println(sum);
    }

    public static int sum(int input[]) {
        if (input.length == 1) {
            return input[0];
        }

        int newArray[] = Arrays.copyOfRange(input, 1, input.length);
        int smallOutput = sum(newArray);
        return smallOutput + input[0];
    }
}
