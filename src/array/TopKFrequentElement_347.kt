package array

import java.util.*

/**
 * 347. Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 *
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 *
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
class TopKFrequentElement_347 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            TopKFrequentElement_347().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), k = 2).forEach { print("$it , ") }
            println()
            TopKFrequentElement_347().topKFrequent(intArrayOf(1), k = 1).forEach { print("$it , ") }
            println()
        }
    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {


        val map = mutableMapOf<Int, Int>()
        for (n in nums) {
            map[n] = map.getOrDefault(n, 0) + 1
        }

        //Created MAX Heap where 1st index higher value must be on top
        val maxHeap = PriorityQueue<IntArray> { o1, o2 -> o2[1] - o1[1] }

        for (entry in map.entries) {
            maxHeap.add(intArrayOf(entry.key, entry.value))
        }

        val result = IntArray(k)
        var i = 0
        while (i < k) {
            result[i++] = maxHeap.poll()[0]
        }

        return result
    }
}