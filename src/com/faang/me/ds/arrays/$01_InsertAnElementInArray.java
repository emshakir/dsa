package com.faang.me.ds.arrays;

import java.util.Arrays;

public class $01_InsertAnElementInArray {

    public static void main(String[] args) {
        int array[] = new int[6];
        for (int i = 0; i < array.length - 2; i++) {
            array[i] = (int) Math.floor(Math.random() * 10);
        }

        array = insertElement(array, array.length - 2, 6, 25);
        System.out.println(Arrays.toString(array));
    }

    static int[] insertElement(int[] array, int arrLength, int position, int numberToBeinserted) {
        int positionIdx = position - 1;
        for (int i = arrLength; i >= positionIdx; i--) {
            array[i + 1] = array[i];
        }
        array[positionIdx] = numberToBeinserted;
        return array;
    }

}
