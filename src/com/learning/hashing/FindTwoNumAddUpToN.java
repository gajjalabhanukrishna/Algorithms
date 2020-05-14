package com.learning.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindTwoNumAddUpToN {

    public int [] findSum(int arr[], int n){

        Map<Integer, Integer> map = new HashMap<>();
        if(arr.length == 0){
            return new int[0];
        }

        for(int i =0; i< arr.length; i++){
            if(map.containsKey(arr[i])){
                return new int[]{arr[i], arr[map.get(arr[i])]};
            }else{
                map.put(n - arr[i], i);
            }
        }


        return new int[0];
    }

    public static void main(String[] args) {
        int []arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int n = 27;
        FindTwoNumAddUpToN twoNumAddUpToN = new FindTwoNumAddUpToN();

        int result[] = twoNumAddUpToN.findSum(arr, n);

        System.out.println(result);

    }
}
