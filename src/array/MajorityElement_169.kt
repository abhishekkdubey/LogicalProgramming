package array

/**
 * 169. Majority Element
 *
 * Given an array nums of size n, return the majority element.
 *
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 *
 * Output: 2
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1


 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
class MajorityElement_169 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(MajorityElement_169().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
        }
    }

    fun majorityElement(nums: IntArray): Int {
        var m = nums[0]
        var count = 1

        for (i in 1..nums.lastIndex) {
            if (nums[i] == m) {
                count++
            } else {
                count--
            }
            if (count == 0) {
                m = nums[i]
                count = 1
            }
        }
        return m
    }

    fun majorityElementBySorting(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size/2]
    }
}