package array

import java.util.*


/**
 *
 * Explanation: https://leetcode.com/problems/minimize-deviation-in-array/discuss/1781805/A-very-very-Highly-Detailed-EXPLANATION

 * 1675. Minimize Deviation in Array
 *
 *
 * You are given an array nums of n positive integers.
 *
 * You can perform two types of operations on any element of the array any number of times:
 *
 * If the element is even, divide it by 2.
 *
 * For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
 *
 * If the element is odd, multiply it by 2.
 *
 * For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
 * The deviation of the array is the maximum difference between any two elements in the array.
 *
 * Return the minimum deviation the array can have after performing some number of operations.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 *
 * Output: 1
 * Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.
 *
 * Example 2:
 * Input: nums = [4,1,5,20,3]
 *
 * Output: 3
 * Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
 *
 * Example 3:
 *
 * Input: nums = [2,10,8]
 * Output: 3
 *
 * Constraints:
 *
 * n == nums.length
 * 2 <= n <= 105
 * 1 <= nums[i] <= 109
 */
class MinimizeDeviationInArray_1675 {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(MinimizeDeviationInArray_1675().minimumDeviation(intArrayOf(1, 2, 3, 4)))
        }
    }

    fun minimumDeviation(nums: IntArray): Int {
        // change to treeset as treeset is a order set
        val ts = TreeSet<Int>()
        for (i in 0.. nums.lastIndex) {
            if (nums[i] % 2 == 1) nums[i] *= 2
            ts.add(nums[i]) // just add the value in the treeset
        }
        var diff = Int.MAX_VALUE
        while (true) {
            val max = ts.last() // as it is a sorted set, max value will be at the end of the set
            val min = ts.first() // and min value at the front
            diff = diff.coerceAtMost(max - min)
            if (max % 2 == 0) { // if it's a even value
                ts.remove(max) // first remove the value
                ts.add(max / 2) // add the value called max/2 into the treeset
            } else { // if it's odd just break it
                break
            }
        }
        return diff
    }
}