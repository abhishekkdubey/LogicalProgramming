package challange_30days

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
class KadaneAlgorithm {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

//            println(KadaneAlgorithm().maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
            println(KadaneAlgorithm().sol(intArrayOf(1, 3, 6, 4, 1, 2)))

        }
    }

    /**
     * To Solve this Algorithm, We need to look for the sum in continuation and at the same time look for maximum sum
     *
     * So, for that, I have taken two variable one for storing `absolute sum` and another for storing `maximum sum`
     *
     * Loop through the number array and check if `current` is greater or sum of `absolute + current` is greater than store in absolute sum.
     *
     * This will help for in case `-ve` number is available in start of `number array`
     *
     * Mean also look for maximum in every iteration.
     */
    fun maxSubArray(nums: IntArray): Int {
        var absSum = nums[0]
        var maxSum = nums[0]

        for(i in 1..nums.lastIndex){
            absSum = maxOf(nums[i], nums[i]+absSum)
            maxSum= maxOf(absSum, maxSum)
        }
        return maxSum
    }


    fun sol(A: IntArray): Int{
        val arr = IntArray(1000001){0}
        var max = 0
        for (n in A){
            if (n>0){
                arr[n]+=1
            }
            max = maxOf(max, n)
        }

        for (i in 1..max+1){
            if (arr[i]==0){
                return i
            }
       }
        return max+1
    }
}