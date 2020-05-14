package com.learning.arrays;

public class BinarySearchOn2DArray {

    public static boolean findElement(int arr[][], int key){
        int rows = arr.length;
        int cols = arr[0].length;
        int left = 0;
        int right = (rows * cols) - 1;

        if(arr.length == 0){
            return false;
        }

        while(left <= right){
         int middle = left + (right - left)/2;

         int middleElement = arr[middle/cols][middle%cols];

         if(key == middleElement){
             return true;
         }
         else if(key < middleElement){
             right = middle - 1;
         } else if(key > middleElement){
             left = middle + 1;
         }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(findElement(arr, 9));
    }
}
