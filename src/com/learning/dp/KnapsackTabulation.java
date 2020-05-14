package com.learning.dp;

public class KnapsackTabulation {


    private int knapsackRecursive(Integer dp[][], int[] profits, int[] weights, int capacity) {

        if(capacity <= 0 || profits.length ==0 || profits.length != weights.length){
            return 0;
        }

        for(int i =0 ; i < profits.length; i++){
            dp[i][0] = 0;
        }

        for(int i = 0; i<= capacity; i++){
            if(weights[0] <= capacity){
                dp[0][i] = profits[0];
            }
        }


        for(int i = 1; i< profits.length; i++){
            for(int j= 1; j<= capacity; j++){
                int profit1= 0, profit2 = 0;
                if(weights[i] <= capacity){
                    profit1 = profits[i] + dp[i-1][j-weights[i]];
                }

                profit2 = dp[i-1][j];

                dp[i][j] = Math.max(profit1, profit2);
            }
        }



        return dp[profits.length-1][capacity];
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer dp[][] =  new Integer[profits.length][capacity];
        return this.knapsackRecursive(dp, profits, weights, capacity);
    }

    public static void main(String[] args) {
        int  profit [] = {1, 6, 10, 16};
        int weight[] = {1, 2, 3, 5};
        int capacity = 7;

        KnapsackTabulation k = new KnapsackTabulation();

        int maxProfit =  k.solveKnapsack(profit, weight, capacity);

        System.out.println(maxProfit);

    }
}
