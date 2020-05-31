package com.example.logical

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 *
 *
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 *
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 *
 *
 * Find and return the required subarray.
 *
 *
 * NOTE:
 *
 *
 * 1. If there is a tie, then compare with segment's length and return segment which has maximum length.
 * 2. If there is still a tie, then return the segment with minimum starting index.
 *
 *
 *
 *
 * Input Format:
 *
 *
 * The first and the only argument of input contains an integer array A, of length N.
 * Output Format:
 *
 *
 * Return an array of integers, that is a subarray of A that satisfies the given conditions.
 * Constraints:
 *
 *
 * 1 <= N <= 1e5
 * 1 <= A[i] <= 1e5
 * Examples:
 *
 *
 * Input 1:
 * A = [1, 2, 5, -7, 2, 3]
 *
 *
 * Output 1:
 * [1, 2, 5]
 *
 *
 * Explanation 1:
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3].
 *
 *
 * Input 2:
 * A = [10, -1, 2, 3, -4, 100]
 *
 *
 * Output 2:
 * [100]
 *
 *
 * Explanation 2:
 * The three sub-arrays are [10], [2, 3], [100].
 * The answer is [100] as its sum is larger than the other two.
 */
object MaxNonNegativeSubArray {
    @JvmStatic
    fun main(args: Array<String>) {
        println(
            maxNonNegativeSubArraySum(intArrayOf(1, 2, 5, -7, 2, 3, 4, -2, 0, 8, -3)).contentToString()
        )
        println(maxNonNegativeSubArraySum(intArrayOf(-1, -1, -1, -1, -1, -1)).contentToString())

        println(
            maxNonNegativeSubArraySum(
            intArrayOf(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011,
                -1131176229, -859484421 )).contentToString()
        )
        println(
            maxNonNegativeSubArraySum(
                intArrayOf(756898537, -1973594324, -2038664370, -184803526, 1424268980)).contentToString()
        )
    }

    private fun maxNonNegativeSubArraySum(A: IntArray): IntArray {
        var absSum: Long = 0
        var maxSum: Long = 0
        var maxSumSubArray = IntArray(0)
        var start = -1
        var doChanges = false
        var i = 0
        while (i < A.size) {
            if (A[i] >= 0) {
                if (start == -1) {
                    start = i
                }
                absSum += A[i]
                if (i == A.size - 1) {
                    doChanges = true
                }
            } else {
                doChanges = true
            }
            if (doChanges) {
                doChanges = false
                if (start > -1) {
                    if (i == A.size - 1) {
                        i++
                    }
                    val subArr = A.copyOfRange(start, i)
                    if (maxSum == absSum) {
                        if (maxSumSubArray.size < subArr.size) {
                            maxSumSubArray = subArr
                        } else if (maxSumSubArray.size == subArr.size) {
                            if (maxSumSubArray[0] < subArr[0]) {
                                maxSumSubArray = subArr
                            }
                        }
                    } else if (maxSum < absSum) {
                        maxSumSubArray = subArr
                    }
                    maxSum = maxSum.coerceAtLeast(absSum)
                    start = -1
                    absSum = 0
                }
            }
            i++
        }
        return maxSumSubArray
    }
}