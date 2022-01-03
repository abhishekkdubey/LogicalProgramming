package com.example.algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new SelectionSort().selectionSort(new int[]{10, 5, 30, 15, 50, 5, 25, 35, 1})));
    }

    public int[] selectionSort(int[] arr){

        for (int i=0; i<arr.length-1; i++){
            int min =i;
            for (int j = i+1; j<arr.length; j++){
                if (arr[j]<arr[min]){
                    min= j;
                }
            }
            int temp =arr[i];
            arr[i] =arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}
