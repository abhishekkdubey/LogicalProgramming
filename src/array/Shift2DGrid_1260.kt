package array

/**
 * 1260. Shift 2D Grid
 *
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 *
 * In one shift operation:
 *
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 *
 * Example 1:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 *
 * Example 2:
 *
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 *
 * Example 3:
 *
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
class Shift2DGrid_1260 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                Shift2DGrid_1260().shiftGrid(
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
                    1
                )
            )
            println(
                Shift2DGrid_1260().shiftGrid(
                    arrayOf(
                        intArrayOf(3, 8, 1, 9),
                        intArrayOf(19, 7, 2, 5),
                        intArrayOf(4, 6, 11, 10),
                        intArrayOf(12, 0, 21, 13)
                    ), 4
                )
            )
        }
    }

    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {


        val total = grid.size * grid[0].size
        val column = grid[0].size
        val result = ArrayList<List<Int>>()
        val newK = k% total
        for (i in 0..grid.lastIndex) {
            val list = ArrayList<Int>()
            for (j in 0..grid[i].lastIndex) {

                //Main Formula to calculate flat Index value in 2D array for rotated array value
                val flatIndex = (i * column + j + total - k) % total
                //Use flat index value to pick right grid index value need to add into result array
                list.add(grid[flatIndex / column][flatIndex % column])
            }
            result.add(list)
        }
        return result
    }
}