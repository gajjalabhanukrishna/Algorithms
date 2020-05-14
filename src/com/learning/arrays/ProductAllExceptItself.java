package com.learning.arrays;

public class ProductAllExceptItself {
    public static int[] productAllExceptItself(int arr[]){
        int rightArr[] = new int[arr.length];
        int leftArr[] = new int[arr.length];
        int result[] = new int[arr.length];

        leftArr[0]= 1;
        rightArr[arr.length-1]= 1;

        for(int i = 1; i<arr.length; i++){
            leftArr[i] = leftArr[i-1]* arr[i-1];
        }

        for(int i = arr.length-1; i>0; i--){
            rightArr[i-1] = rightArr[i]* arr[i];
        }

        for(int i = 0; i<arr.length; i++){
            result[i] = leftArr[i]* rightArr[i];
        }

        return result;
    }

    public static String print(int arr[]){
        String re = "";

        for(int i = 0; i < arr.length; i++){
            re += arr[i] + ",";
        }

        return re;
    }


    public static void main(String[] args) {
        int  arr[] = {1, 2, 3, 4, 5};

        int[] result = productAllExceptItself(arr);


        System.out.println(print(result));
        int  arr1[] = {3, 2, 1};

        int[] result1 = productAllExceptItself(arr1);


        System.out.println(print(result1));

    }
}
