package array

import kotlin.math.abs


/**
 * 16. 3Sum Closest
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 *
 * Output: 2
 *
 *
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 *
 *
 * Input: nums = [0,0,0], target = 1
 *
 * Output: 0
 *
 * Constraints:
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
class ThreeSumClosest_16 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

//            println(ThreeSumClosest_16().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
//            println(ThreeSumClosest_16().threeSumClosest(intArrayOf(0, 0, 0, 0), 1))
            println(ThreeSumClosest_16().threeSumClosest(intArrayOf(1, 1, -1, -1, 3), -1))
        }
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {

        var sum = Int.MAX_VALUE

        nums.sort()
        for (i in 0..nums.lastIndex) {

            var s = i + 1
            var e = nums.lastIndex

            while (s < e) {
                val tempSum = nums[s] + nums[e] + nums[i]
                val diff = if (sum==Int.MAX_VALUE && target<0){
                    Int.MAX_VALUE
                }else{
                    abs(target - sum)
                }
                if (abs(target - tempSum) < diff) {
                    sum = tempSum
                }

                if (tempSum > target) {
                    e--
                } else {
                    s++
                }

            }

        }
        return sum


    }
}