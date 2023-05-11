package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 22/10/2022
 */
public class LastIndexOfNumberInArray {

    public static void main(String[] args) {
        int[] array = {9, 8, 10, 8, 8, 10};
        int number = 9;
        int firstIndex = getLastIndexOfNumber(array, number, array.length - 1);
        System.out.println(firstIndex);
        int firstIndexOptimal = getLastIndexOfNumberOptimal(array, number, 0);
        System.out.println(firstIndexOptimal);
    }

    private static int getLastIndexOfNumber(int[] input, int number, int ei) {
        if (ei < 0) {
            return -1;
        }

        if (input[ei] == number) {
            return ei;
        }

        return getLastIndexOfNumber(input, number, ei - 1);
    }

    private static int getLastIndexOfNumberOptimal(int[] input, int number, int si) {

        // Base Condition
        if (si == input.length) {
            return -1;
        }

        int smallInput = getLastIndexOfNumberOptimal(input, number, si + 1);

        //Once we reach end of array this will get last index position
        if (smallInput != -1) {
            return smallInput;
        } else {
            if (input[si] == number) {
                return si;
            } else {
                return -1;
            }
        }
    }

}
