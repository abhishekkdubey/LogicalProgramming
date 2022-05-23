package array


/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 *
 * Input: n = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 */
class SpiralMatrix_II_59 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val res = SpiralMatrix_II_59().generateMatrix(3)
            res.toList().forEach { println(it.toList()) }
        }
    }

    /**
     * ALGORITHM

    We have to fill the matrix layer by layer in four direction.
    From left to right ➡️:
    the row will remain constant while column is updated till reaches n-1.
    From Top to bottom ⬇️(moving down)
    The column will remain constant as n-1 and we will start filling from r1 + 1, as first row is filled in previous step & row will be updated.
    From right to left ⬅️
    we will start filling from c2 - 1 because c2 is filled in previous step.
    so the row will be fixed and c2 will be updated from c2-1 till its greater than c1.
    From botom to up ⬆️ (move up)
    the column will be fixed as c1 while row will be updated form r2 till it greater than r1.
    After that we will updates the row and column pointers, as now we will have to fill the inner layers.
     */
    fun generateMatrix(n: Int): Array<IntArray> {

        val result = Array(n) { IntArray(n) { 0 } }

        var left = 0
        var top = 0
        var right = n - 1
        var down = n - 1
        var count = 1
        while (left <= right) {
            for (j in left..right) {
                result[top][j] = count++
            }
            top++
            for (i in top..down) {
                result[i][right] = count++
            }
            right--
            for (j in right downTo left) {
                result[down][j] = count++
            }
            down--
            for (i in down downTo top) {
                result[i][left] = count++
            }
            left++
        }
        return result
    }
}