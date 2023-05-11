package com.apna_college.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class $04_NextGreaterElement {

    public static int[] getNextElementArr(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer> s = new Stack<>();

        for (int i = input.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && input[s.peek()] >= input[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                output[i] = -1;
            } else {
                output[i] = input[s.peek()];
            }
            s.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(getNextElementArr(input)));
    }
}
