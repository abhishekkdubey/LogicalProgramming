package array

import kotlin.math.pow

/**
 *923. 3Sum With Multiplicity
 *
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 * Example 1:
 *
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 *
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 *
 * Example 2:
 *
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 * Constraints:
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 */
class ThreeSumWithMultiplicity_923 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(ThreeSumWithMultiplicity_923().threeSumMulti(intArrayOf(1,1,2,2,3,3,4,4,5,5), 8))
            println(ThreeSumWithMultiplicity_923().threeSumMulti(intArrayOf(1,1,2,2,2,2), 5))
        }
    }

    /**
     * _n C_r=\frac{n !}{r ! (n-r) !}
    _n C_r	=	number of combinations
    n	=	total number of objects in the set
    r	=	number of choosing objects from the set

     */
    fun threeSumMulti(arr: IntArray, target: Int): Int {
        //First we check the frequency of every number
        val map = mutableMapOf<Int, Int>()
        var result: Long = 0

        for (i in 0..arr.lastIndex) {

            result += (map.getOrDefault(target - arr[i], 0))
            for (j in 0 until i){
                map[arr[i]+arr[j]] = map.getOrDefault(arr[i]+arr[j], 0)+1
            }
        }
        return( result % (10.0.pow(9.0) +7)).toInt()
    }
}