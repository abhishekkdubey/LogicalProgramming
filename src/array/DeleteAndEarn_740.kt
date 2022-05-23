package array

/**
 *
 * 740. Delete and Earn
 *
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 *
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 *
 * Example 1:
 *
 * Input: nums = [3,4,2]
 * Output: 6
 *
 * Explanation: You can perform the following operations:
 * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
 * - Delete 2 to earn 2 points. nums = [].
 * You earn a total of 6 points.
 * Example 2:
 *
 * Input: nums = [2,2,3,3,3,4]
 * Output: 9
 * Explanation: You can perform the following operations:
 * - Delete a 3 to earn 3 points. All 2's and 4's are also deleted. nums = [3,3].
 * - Delete a 3 again to earn 3 points. nums = [3].
 * - Delete a 3 once more to earn 3 points. nums = [].
 * You earn a total of 9 points.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
class DeleteAndEarn_740 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(DeleteAndEarn_740().deleteAndEarn1(intArrayOf(3,4,2)))
            println(DeleteAndEarn_740().deleteAndEarn1(intArrayOf(2,2,3,3,3,4)))
        }
    }


    fun deleteAndEarn1(nums: IntArray): Int {
        val arr = IntArray(10001) { 0 }
        var max = 0
        for (n in nums) {
            arr[n]+=n
            max = maxOf(max, n)
        }

        var include = arr[1]
        var exclude = 0

        for (i in 2..max){
            val newInclude = exclude+arr[i]
            exclude = include
            include = maxOf(newInclude, include)
        }
        return include
    }

    fun deleteAndEarn(nums: IntArray): Int{
        val sum = IntArray(10001) { 0 }
        var max = 0
        for (i in 0..nums.lastIndex){
            sum[nums[i]]+=nums[i]
            max = maxOf(max, nums[i])
        }
        for (i in 2..max){
            sum[i] = maxOf(sum[i-1], sum[i-2]+sum[i])
        }
        return sum[max]
    }

}