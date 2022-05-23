package array

/**
 * 289. Game of Life
 *
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 *
 *
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 *
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */
class GameOfLife_289 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            GameOfLife_289().gameOfLife(arrayOf(intArrayOf(0,1,0),intArrayOf(0,0,1),intArrayOf(1,1,1),intArrayOf(0,0,0)))
        }

    }

    fun gameOfLife(board: Array<IntArray>): Unit {

        val indexPairs = arrayOf(
            Pair(1, -1),
            Pair(1, 1),
            Pair(0, 1),
            Pair(1, 0),
            Pair(-1, 1),
            Pair(0, -1),
            Pair(-1, 0),
            Pair(-1, -1)
        )


        playLifeGame(board, indexPairs)
        updateWithNewLife(board)
        board.toList().forEach { println(it.toList()) }

    }

    private fun updateWithNewLife(board: Array<IntArray>) {
        for (i in 0..board.lastIndex) {
            for (j in 0..board[i].lastIndex) {
                if (board[i][j] != 0) {
                    board[i][j] = board[i][j] shr 1
                }
            }
        }
    }

    private fun playLifeGame(
        board: Array<IntArray>,
        indexPairs: Array<Pair<Int, Int>>
    ) {
        for (i in 0..board.lastIndex) {
            for (j in 0..board[i].lastIndex) {
                val count = lifeCount(board, indexPairs, i, j)

                //Dead Cell with three live neighbour can alive
                if ((board[i][j] == 0 && count == 3)) {
                    board[i][j] = 2

                } else if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3
                }
            }
        }
    }

    private fun lifeCount(board: Array<IntArray>, indexPairs: Array<Pair<Int, Int>>, i: Int,j: Int): Int {
        var count = 0
        for (pair in indexPairs) {
            if (isValidIndex(board.size, board[i].size, i + pair.first, j + pair.second)) {
                count += (board[i + pair.first][j + pair.second] and 1)
            }
        }
        return count
    }

    private fun isValidIndex(row: Int, col: Int, i: Int, j: Int): Boolean {
        return (i >= 0 && j >= 0 && i < row && j < col)

    }


}