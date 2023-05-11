package com.faang.me.grind75.arrays;

/**
 * Created By Mohammad Shakir - 22/09/2022
 */
public class $02_BestTimeToBuyAndSellStock_LC_121 {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;

        getMaxPrice(prices, n);
        getMaxPriceOpt(prices, n);
    }

    private static int getMaxPriceOpt(int[] prices, int n) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    private static void getMaxPrice(int[] prices, int n) {
        int curr = 0;
        int next = 1;
        int maxProfit = Integer.MIN_VALUE;
        while (next < n) {
            if (prices[curr] < prices[next]) {
                int currProft = prices[next] - prices[curr];
                maxProfit = Math.max(maxProfit, currProft);
                       
            } else {
                curr = next;
            }
            next++;
        }
    }
}
