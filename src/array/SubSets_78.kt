package array

import java.util.*
import kotlin.collections.ArrayList


 /**
 * 78. Subsets
 *
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2:
 *
 * Input: nums = [0]
 *
 * Output: [[],[0]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 *
 * -10 <= nums[i] <= 10
 *
 * All the numbers of nums are unique.
 */
class SubSets_78 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(SubSets_78().subsets(intArrayOf(1, 2, 3)))
        }
    }


    fun subsets(nums: IntArray): List<List<Int>> {

        val result = ArrayList<List<Int>>()

        helperSubsets(nums, 0, result, LinkedList<Int>())

        return result
    }


    fun helperSubsets(
        arr: IntArray,
        index: Int,
        result: ArrayList<List<Int>>,
        subSet: LinkedList<Int>
    ) {

        if (index == arr.size) {
            result.add(ArrayList(subSet))
            return
        }
        subSet.push(arr[index])
        helperSubsets(arr, index + 1, result, subSet)
        subSet.pop()
        helperSubsets(arr, index + 1, result, subSet)
    }
}