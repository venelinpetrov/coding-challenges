package com.vpe;

/*
    Given a array of numbers representing the stock prices of a company in chronological order,
    write a function that calculates the maximum profit you could have made from buying and selling that stock once.
    You must buy before you can sell it.

    For example, given [9, 11, 8, 5, 7, 10], you should return 5,
    since you could buy the stock at 5 dollars and sell it at 10 dollars.
*/
public class MaxProfit {
    // Naive solution O(n^2)
    public static int getMaxProfit(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            int buyPrice = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                int sellPrice = arr[j];

                if (sellPrice < buyPrice) {
                    continue;
                }

                if (sellPrice - buyPrice > max) {
                    max = sellPrice - buyPrice;
                }
            }
        }

        return max;
    }

    // Solution O(n)
    public static int getMaxProfit2(int[] arr) {
        int maxProfit = 0;
        int minPrice = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currPrice = arr[i];
            int profit = currPrice - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (currPrice < minPrice) {
                minPrice = currPrice;
            }
        }

        return maxProfit;
    }
}
