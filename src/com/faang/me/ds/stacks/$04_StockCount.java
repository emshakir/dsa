package com.faang.me.ds.stacks;

import java.util.Stack;

/**
 * Created By Mohammad Shakir - 10/12/2022
 */
public class $04_StockCount {

    public static void main(String[] args) {
        int[] arr = {60, 70, 80, 100, 90, 75, 80, 120};

    }

    public static int[] stockSpan(int[] price) {

        int[] spanArr = new int[price.length];
        Stack<Integer> stack = new Stack<>();
        spanArr[0] = 1;
        stack.push(0);
        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[i] > price[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                spanArr[i] = i + 1;
            } else {
                spanArr[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return spanArr;
    }
}
