package com.faang.me.codingninjas.recursion;

import java.util.HashMap;

/**
 * Created By Mohammad Shakir - 30/10/2022
 */
public class PairSumInArray {

    static int getPairsCount(int arr[], int n, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (m.containsKey(k - arr[i])) {
                count += m.get(k - arr[i]);
            }
            int temp = m.getOrDefault(m.get(arr[i]), 0);
            m.put(arr[i], temp + 1);
//            if (m.containsKey(arr[i])) {
//                m.put(arr[i], m.get(arr[i]) + 1);
//            } else {
//                m.put(arr[i], 1);
//            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {3, 3, 3, 3, 3};
        int sum = 6;
        int count = getPairsCount(arr, arr.length, sum);
        System.out.println(count);
    }
}
