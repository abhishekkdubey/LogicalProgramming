package array

/**
 * 15. 3Sum
 * Medium
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
class ThreeSum_15 {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            println(ThreeSum_15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))

        }
    }


    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result = HashSet<ArrayList<Int>>()
        for (i in 0..nums.lastIndex) {

            val remPairs = twoSum(nums, i + 1, nums.lastIndex, -nums[i])

            for (pairs in remPairs) {
                val subRes = ArrayList<Int>()
                subRes.add(nums[i])
                subRes.add(pairs.first)
                subRes.add(pairs.second)
                result.add(subRes)
            }
        }

        return result.toList()
    }


    fun twoSum(arr: IntArray, start: Int, end: Int, target: Int): List<Pair<Int, Int>> {

        var s = start
        var e = end

        val result = ArrayList<Pair<Int, Int>>()

        while (s < e) {
            if (s > start && arr[s] == arr[s - 1]) {
                s++
                continue
            }


            if (e < end && arr[e] == arr[e + 1]) {
                e--
                continue
            }
            val sum = arr[s] + arr[e]
            if (sum == target) {
                result.add(Pair(arr[s], arr[e]))
                s++
                e--
            } else if (sum < target) {
                s++
            } else {
                e--
            }


        }

        return result

    }
}