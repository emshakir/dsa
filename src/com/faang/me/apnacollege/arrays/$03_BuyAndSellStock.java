package com.faang.me.apnacollege.arrays;

/**
 *
 * Created by Mohammad Shakir - 09/04/2023
 */
public class $03_BuyAndSellStock {

    public static int getProfit(int[] a) {
        int profit = 0;
        int minPrice = a[0];
        for (int i = 1; i < a.length; i++) {
            int currentPrice = a[i] - minPrice;
            profit = Math.max(profit, currentPrice);
            minPrice = Math.min(a[i], minPrice);
        }
        return profit;
    }

    public static int getMaxProfit(int[] a) {
        int profit = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (buyPrice < a[i]) {
                int current = a[i] - buyPrice;
                profit = Math.max(profit, current);
            } else {
                buyPrice = a[i];
            }
        }
        return profit;
    }
}
