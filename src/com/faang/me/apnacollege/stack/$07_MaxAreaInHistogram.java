package com.faang.me.apnacollege.stack;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 23/01/2023
 */
public class $07_MaxAreaInHistogram {


    public static int[] getNextSmallerLeft(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            int currentEle = input[i];
            while (!s.isEmpty() && currentEle <= input[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = s.peek();
            }
            s.push(i);
        }
        return output;
    }

    public static int[] getNextSmallerRight(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer> s = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            int curr = input[i];
            while (!s.isEmpty() && curr <= input[s.peek()]) {
                s.pop();
            }

            if (s.isEmpty()) {
                output[i] = input.length;
            } else {
                output[i] = s.peek();
            }
            s.push(i);
        }
        return output;
    }

    public static int getMaxArea(int[] arr) {

        int max = 0;
        int[] nsr = getNextSmallerRight(arr);
        int[] nsl = getNextSmallerLeft(arr);

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            max = Math.max(max, currArea);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println("Height of Histogram ::::: " + getMaxArea(arr));
    }
}
