package google.practice

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
class MergeInterval_56 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            MergeInterval_56().merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)))
                .also { it -> it.forEach { print("[${it.first()}, ${it.last()}] ") }  }
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val arr = Array(intervals.size){ intArrayOf(-1, -1) }
        var n = 0
        intervals.sortBy { it.first() }
        arr[n++] = intervals[0]
        for (i in 1..intervals.lastIndex) {
            if (arr[n-1].last()>=intervals[i].first()){
                arr[n-1][1] = intervals[i].last()
            }else{
                arr[n++] = intervals[i]
            }

        }
        return arr.copyOfRange(0, n)
    }
}