package com.apna_college.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created By Mohammad Shakir - 22/01/2023
 */
public class $04_StackSpan {


    public static int[] stackCountNaive(int[] price) {
        int[] span = new int[price.length];

        // first element will be 1
        span[0] = 1;
        for (int i = 1; i < price.length; i++) {
            span[i] = 1;

            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--) {
                span[i]++;
            }
        }
        return span;
    }

    public static int[] stackCountOptimised(int[] price) {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[price.length];
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < price.length; i++) {
            int currPrice = price[i];
            while (!s.isEmpty() && price[s.peek()] <= currPrice) {
                s.pop();
            }

            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
        return span;

    }

    public static void main(String[] args) {

//        int price[] = {100, 80, 60, 70, 60, 75, 85};
        int price[] = {100, 80, 60, 70, 60, 85, 100};
        int[] res = stackCountNaive(price);
        int[] resOpt = stackCountOptimised(price);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(resOpt));
    }
}
