package com.example.algorithm.sorting;

import java.util.Arrays;

public class MergeSort {


    private  void mergeSort(int[] arr, int start, int end) {

        if (start < end) {
            int m = start+(end - start) / 2;
            mergeSort(arr, start, m);
            mergeSort(arr, m+1, end);
            merge(arr, start, m, end);
        }

    }


    private  void merge(int[] arr, int start, int mid, int end) {

        int l1 = mid - start + 1;
        int l2 = end - mid;


        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];

        for (int i = 0; i < l1; i++) {
            arr1[i] = arr[start + i];
        }

        for (int j = 0; j < l2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = start;

        while (i<l1 && j<l2){
            if (arr1[i]<arr2[j]){
                arr[k] =arr1[i];
                i++;
            }else{
                arr[k] =arr2[j];
                j++;
            }
            k++;
        }
        while (i <l1){
            arr[k] =arr1[i];
            i++;
            k++;

        }
        while (j<l2){
            arr[k]  = arr2[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr=  {1, 5, 2, 1};
//        int[] arr = { 12, 11, 13, 5, 6, 7 };
        System.out.println(Arrays.toString(arr));
        new MergeSort().mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
