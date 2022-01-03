package com.example.algorithm.sorting;

import java.util.Arrays;

public class QuickSort {


    public static int iteration = 0;

    public static void main(String[] args) {

        iteration=0;
        int[] data = { 8, 7, 2, 1, 0, 9, 6 , 5, 4, 11};
        System.out.println(Arrays.toString(data));
        quickSort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
        System.out.println("Quick Sort for "+data.length+" size data took total of iteration "+iteration);

    }


    static void quickSort(int[] arr, int low, int high){
        if (low<high) {
            int m = pivote(arr, low, high);
            quickSort(arr, low, m-1);
            quickSort(arr,  m+1, high);
        }
    }

     static int pivote(int[] arr, int low, int high) {

        int piv = arr[high];
        int i = low-1;
        for (int j=low; j<=high; j++){
            iteration++;
            if (arr[j]<=piv){
                i++;

                int temp= arr[j];
                arr[j] = arr[i];
                arr[i]= temp;
            }
        }
        return i;
    }
}
