package com.example.logical;

import java.util.Arrays;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required subarray.
 * <p>
 * NOTE:
 * <p>
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 * <p>
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 * <p>
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 * <p>
 * Output 1:
 * [1, 2, 5]
 * <p>
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 * <p>
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 * <p>
 * Output 2:
 * [100]
 * <p>
 * Explanation 2:
 * The three sub-arrays are [10], [2, 3], [100].
 * The answer is [100] as its sum is larger than the other two.
 */
public class MaxNonNegativeSubArray_Java {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxNonNegativeSubArraySum(new int[]{1, 2, 5, -7, 2, 3, 4, -2, 0, 8, -3})));
        System.out.println(Arrays.toString(maxNonNegativeSubArraySum(new int[]{-1, -1, -1, -1, -1, -1})));
        System.out.println(Arrays.toString(maxNonNegativeSubArraySum(new int[]{336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421})));
        System.out.println(Arrays.toString(maxNonNegativeSubArraySum(new int[]{756898537, -1973594324, -2038664370, -184803526, 1424268980})));
    }

    private static int[] maxNonNegativeSubArraySum(int[] A) {
        long absSum = 0;
        long maxSum = 0;
        int[] maxSumSubArray = new int[0];
        int start = -1;
        boolean doChanges = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                if (start == -1) {
                    start = i;
                }
                absSum += A[i];
                if (i == A.length - 1) {
                    doChanges = true;
                }
            } else {
                doChanges = true;
            }

            if (doChanges) {
                doChanges = false;
                if (start > -1) {
                    if (i == A.length - 1) {
                        i++;
                    }
                    int[] subArr = Arrays.copyOfRange(A, start, i);
                    if (maxSum == absSum) {
                        if (maxSumSubArray.length < subArr.length) {
                            maxSumSubArray = subArr;
                        } else if (maxSumSubArray.length == subArr.length) {
                            if (maxSumSubArray[0] < subArr[0]) {
                                maxSumSubArray = subArr;
                            }
                        }
                    } else if (maxSum < absSum) {
                        maxSumSubArray = subArr;
                    }
                    maxSum = Math.max(maxSum, absSum);
                    start = -1;
                    absSum = 0;
                }

            }
        }
        return maxSumSubArray;
    }


}