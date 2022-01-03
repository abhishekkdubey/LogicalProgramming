package com.example.microsoft.practice;


import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains N integers in an array A.
 * Output Format:
 * <p>
 * Return an integer, representing the minimum candies to be given.
 * Example:
 * <p>
 * Input 1:
 * A = [1, 2]
 * <p>
 * Output 1:
 * 3
 * <p>
 * Explanation 1:
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
 * So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
 * <p>
 * Input 2:
 * A = [1, 5, 2, 1]
 * <p>
 * Output 2:
 * 7
 * <p>
 * Explanation 2:
 * Candies given = [1, 3, 2, 1]
 */
public class DistributeCandy {

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 1};
        System.out.println(distributeCandy(arr));
    }

    private static int distributeCandy(int[] arr) {
        int size = arr.length;
        int[] L2R = new int[size];
        int[] R2L = new int[size];

        Arrays.fill(L2R, 1);
        Arrays.fill(R2L, 1);

        for (int i = 1; i < size; i++) {
            if (arr[i] > arr[i - 1]) {
                L2R[i] = L2R[i - 1] + 1;
            }
        }

        for (int i = size-2; i>=0; i--){
            if (arr[i]>arr[i+1]){
                R2L[i] =R2L[i+1]+1;
            }
        }

        int sum = 0;
        for (int i =0; i<size; i++){
            sum+=Math.max(L2R[i], R2L[i]);
        }
        return sum;
    }


}
