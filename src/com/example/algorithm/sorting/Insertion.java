package com.example.algorithm.sorting;

import java.util.Arrays;

public class Insertion {


    public static void main(String[] args) {


        System.out.println(Arrays.toString(insertionSort(new int[]{30, 10, 50, 20, 60, 40})));
    }


    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int current = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;
        }

        return arr;
    }
}
