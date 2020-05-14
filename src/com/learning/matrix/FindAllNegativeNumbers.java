package com.learning.matrix;

public class FindAllNegativeNumbers {


    public static int countNumbers(int arr[][], int m, int n){
        int totalCount=0;

        int row = 0;
        int col = n-1;

        while(col >= 0 && row < n){
            if(arr[row][col] < 0){
                totalCount += col+1;
                row++;
            } else {
                col--;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int M[][] = { { -3, -2, -1, 1 },
                { -2, 2, 3, 4 },
                { 4, 5, 7, 8 } };

        System.out.println(countNumbers(M, 3, 4));

    }
}
