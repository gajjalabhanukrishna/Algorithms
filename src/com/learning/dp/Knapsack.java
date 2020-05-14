package com.learning.dp;

public class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {

        int  profit1 = 0;

        if(capacity <= 0 || currentIndex >= profits.length){
            return 0;
        }

        if(weights[currentIndex] <= capacity){
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex+1);
        }

        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int  profit [] = {1, 6, 10, 16};
        int weight[] = {1, 2, 3, 5};
        int capacity = 7;

        Knapsack k = new Knapsack();

        int maxProfit =  k.solveKnapsack(profit, weight, capacity);

        System.out.println(maxProfit);

    }
}
