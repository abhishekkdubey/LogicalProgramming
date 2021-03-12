package com.example.practice;

public class LargestContiguousSum {
    public static void main(String[] args) {
        System.out.println(new LargestContiguousSum().largestSum(new int[]{-1, 2, -3, 4, -1, 2, 3, 6, -3, -1}));
    }


    public long largestSum(int[] arr) {
        long max = arr[0];
        long absSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            absSum = Math.max(arr[i], absSum + arr[i]);
            max = Math.max(max, absSum);
        }
        return max;

    }
}
