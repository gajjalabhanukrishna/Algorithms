package com.learning.search;

public class BinarySearch {

    public static int binarySearch(int arr[], int row, int col, int item){


        if(row <= col) {
            int mid = (row + col) / 2;

            if (arr[mid] == item) {
                return mid;
            }

            if (item < arr[mid]) {
                col = mid - 1;
                return binarySearch(arr, row, col, item);
            } else {
                row = mid + 1;
                return binarySearch(arr, row, col, item);
            }
        }
        return -1;
    }

    public static int binarySearchUsingMasterMethod(int arr[], int left, int right, int item){

        while(left <= right){
            int mid = left + (right - left)/2;

            if(item == arr[mid]){
                return mid;
            }
            if(item < arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5,4,3,6,7,8,9,10};

        System.out.println(BinarySearch.binarySearch(arr, 0, arr.length-1, 5));
        System.out.println(BinarySearch.binarySearchUsingMasterMethod(arr, 0, arr.length-1, 5));

    }
}
