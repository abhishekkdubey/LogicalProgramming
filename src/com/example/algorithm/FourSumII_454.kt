package com.example.algorithm

/**
 * 454. 4Sum II
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1


Constraints:

n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
class FourSumII_454 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FourSumII_454().fourSumCount(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2)))
        }
    }


    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val map = mutableMapOf<Int, Int>()

        for (n1 in nums1) {
            for (n2 in nums2) {
                map[n1 + n2] = map.getOrDefault(n1 + n2, 0) + 1
            }
        }
        var sumCount = 0
        for (n3 in nums3) {
            for (n4 in nums4) {
                sumCount += map.getOrDefault(-(n3 + n4), 0)
            }
        }
        return sumCount

    }
}