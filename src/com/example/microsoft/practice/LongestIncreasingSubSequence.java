package com.example.microsoft.practice;


import java.util.Arrays;

/**
 * Find the longest increasing subsequence of a given array of integers, A.
 * <p>
 * In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * <p>
 * This subsequence is not necessarily contiguous, or unique.
 * <p>
 * In this case, we only care about the length of the longest increasing subsequence.
 * <p>
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument is an integer array A.
 * Output Format:
 * <p>
 * Return an integer representing the length of the longest increasing subsequence.
 * Constraints:
 * <p>
 * 1 <= length(A) <= 2000
 * 0 <= A[i] <= 2500
 * Example :
 * <p>
 * Input 1:
 * A = [1, 2, 1, 5]
 * <p>
 * Output 1:
 * 3
 * <p>
 * Explanation 1:
 * The sequence : [1, 2, 5]
 * <p>
 * Input 2:
 * A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * <p>
 * Output 2:
 * 6
 * <p>
 * Explanation 2:
 * The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubSequence {


    public static void main(String[] args) {

        int[] arr1 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int[] arr2 = {1, 2, 1, 5};
        System.out.println(new LongestIncreasingSubSequence().longestIncreasingSubSequence(arr1, arr1.length));
        System.out.println(new LongestIncreasingSubSequence().longestIncreasingSubSequence(arr2, arr2.length));
    }

    public int longestIncreasingSubSequence(int[] arr, int size) {

        int[] LIS = new int[size];
        Arrays.fill(LIS, 1);

        int max = 0;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (max < LIS[i]) {
                max = LIS[i];
            }
        }

        return max;
    }

}
