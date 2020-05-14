package com.learning.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindElementOfSumK {

    public static boolean findSum(int arr[], int k){

        Set<Integer> balance = new HashSet<>();

        if(arr.length <= 0){
            return false;
        }

        for(int i =0; i<arr.length; i++){
            if(balance.contains(k-arr[i])){
                return true;
            }else{
                balance.add(arr[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[] = {10, 15, 3, 7};

        System.out.println(findSum(arr, 11));

    }
}
