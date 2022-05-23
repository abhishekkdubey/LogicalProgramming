package com.example.algorithm

/**
 * 1288. Remove Covered Intervals
 *
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.
 *
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 *
 * Return the number of remaining intervals.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * Example 2:
 *
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 1000
 * intervals[i].length == 2
 * 0 <= li <= ri <= 105
 * All the given intervals are unique.
 */
class RemovedCoveredInterval {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println( RemovedCoveredInterval().removeCoveredIntervals(arrayOf(intArrayOf(1,4),intArrayOf(3,6),intArrayOf(2,8))))
            println( RemovedCoveredInterval().removeCoveredIntervals(arrayOf(intArrayOf(1,2),intArrayOf(1,4),intArrayOf(3,4))))
            println( RemovedCoveredInterval().removeCoveredIntervals(arrayOf(intArrayOf(1,4),intArrayOf(2,3))))
            println( RemovedCoveredInterval().removeCoveredIntervals(arrayOf(intArrayOf(0,2),intArrayOf(1,2))))
        }
    }

    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {

        intervals.sortBy { it.first() }

        var count = 0
        var left = Int.MIN_VALUE
        var right = Int.MIN_VALUE

        for (int in intervals){

            if (left<=int.first() && right<int.last()){
                if (left<int.first())count++
                left = int.first()
                right = int.last()
            }
        }
        return count
    }

}