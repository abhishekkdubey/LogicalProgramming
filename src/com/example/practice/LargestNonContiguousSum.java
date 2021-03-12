package com.example.practice;

public class LargestNonContiguousSum {

    private static int array[] = {1, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        System.out.println(new LargestNonContiguousSum().largestSum(array));
        System.out.println(new LargestNonContiguousSum().largestSum(new int[]{-2, 1,-3, 4,-1, 2, 1, -5, 4}));
    }


    public long largestSum(int[] arr) {
        int inc = arr[0];
        int exc = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = inc;
            inc = Math.max(exc + arr[i], inc);
            exc = temp;
        }

        return inc;
    }

}
