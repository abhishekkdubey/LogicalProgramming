package backtracking

import java.util.*
import kotlin.collections.ArrayList

/**
 * 39. Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 *
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 *
 * Output: []
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 *
 * 1 <= target <= 500
 */
class CombinationSum_39 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(CombinationSum_39().combinationSum(intArrayOf(2,3,6,7), 7))
            println(CombinationSum_39().combinationSum(intArrayOf(2,3,5), 8))
        }
    }


    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {

        val result = ArrayList<List<Int>>()
        val currentCandidate = LinkedList<Int>()
        combinationSumHelper(candidates, target, currentCandidate, 0, 0, result)

        return result
    }


    private fun combinationSumHelper(
        candidates: IntArray,
        target: Int,
        currentCandidate: LinkedList<Int>,
        currentSum: Int,
        index: Int,
        result: ArrayList<List<Int>>
    ) {

        var commonSum = currentSum
        if (commonSum==target){
            val arr = ArrayList<Int>()
            arr.addAll(currentCandidate)
            result.add(arr)
            return
        }
        if (commonSum>target){
            return
        }

        for (i in index..candidates.lastIndex){
            currentCandidate.push(candidates[i])
            commonSum+=candidates[i]
            combinationSumHelper(candidates, target, currentCandidate, commonSum, i, result)
            commonSum-=currentCandidate.pop()
        }
    }


}