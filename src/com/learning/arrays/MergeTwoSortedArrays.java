package com.learning.arrays;

public class MergeTwoSortedArrays {

    public static int[] merge(int arr1[], int arr2[]){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        int k = 0;
        int results[] = new int[n + m];

        while(i < n && j < m){

            if(arr1[i] < arr2[j]){
                results[k++] = arr1[i++];
            }else{
                results[k++] = arr2[j++];
            }
        }

        while(i < n){
            results[k++] = arr1[i++];
        }
        while(j < m){
            results[k++] = arr2[j++];
        }

        return results;
    }


    public static void main(String[] args) {
        int arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8};
        int result[] = merge(arr1, arr2);

        for(int i : result){
            System.out.print(i + ",");
        }

    }
}
