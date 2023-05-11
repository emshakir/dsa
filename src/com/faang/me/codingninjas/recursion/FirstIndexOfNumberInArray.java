package com.faang.me.codingninjas.recursion;

/**
 * Created By Mohammad Shakir - 21/10/2022
 */
public class FirstIndexOfNumberInArray {

    public static void main(String[] args) {

        int[] array = {9, 8, 10, 8};
        int number = 11;
        int firstIndex = getFirstIndexOfNumber(array, number, 0);
        System.out.println(firstIndex);
    }

    private static int getFirstIndexOfNumber(int[] input, int number, int si) {
        if (si == input.length) {
            return -1;
        }

        if (input[si] == number) {
            return si;
        }

        return getFirstIndexOfNumber(input, number, si + 1);
    }


}
