package array

import java.util.regex.Pattern


/**
 * 560. Subarray Sum Equals K
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
class SubArraySumEqualToK_560 {


    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(SubArraySumEqualToK_560().subArraySum(intArrayOf(1, 2, 3), 3))
            println(SubArraySumEqualToK_560().subArraySum(intArrayOf(1, 1, 1), 2))
        }
    }

    fun subArraySum(nums: IntArray, k: Int): Int {

        var count = 0

        var sum = 0
        val map = mutableMapOf<Int, Int>()
        map[0] = 1
        for (i in 0..nums.lastIndex) {
            sum += nums[i]

            val remainingSum = sum - k

            if (map.containsKey(remainingSum)) {
                count += map.getOrDefault(sum - k, 0)
            }
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }

}