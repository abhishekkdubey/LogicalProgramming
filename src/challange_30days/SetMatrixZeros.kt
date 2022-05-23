package challange_30days


/**
Set Matrix Zeroes
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 */
class SetMatrixZeros {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            SetMatrixZeros().setMatrixZeros(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(1, 1, 1)
                )
            ).onEach { it ->
                print("[")
                it.forEach { print("$it, ") }
                print("]")
                println()
            }


            SetMatrixZeros().setMatrixZeros(
                arrayOf(
                    intArrayOf(0, 1, 2, 0),
                    intArrayOf(3, 4, 5, 2),
                    intArrayOf(1, 3, 1, 5)
                )
            ).onEach { it ->
                print("[")
                it.forEach { print("$it, ") }
                print("]")
                println()
            }

        }
    }


    fun setMatrixZeros(matrix: Array<IntArray>): Array<IntArray> {

        var isFirstRowZero = false
        var isFirstColumnZero = false


        //Check if first row contains zero
        for (i in 0..matrix.lastIndex) {
            if (matrix[i][0] == 0) {
                isFirstRowZero = true
            }
        }
        //Check if first column contains zero
        for (j in 0..matrix[0].lastIndex) {
            if (matrix[0][j] == 0) {
                isFirstColumnZero = true
            }
        }


        //Look for the matrix starting from
        for (i in 1..matrix.lastIndex) {
            for (j in 1..matrix[i].lastIndex) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0

                }
            }
        }

        //Check for column, If any 0 found in 0th index
        // colum mark entire row as 0
        for (i in 1..matrix.lastIndex) {
            if (matrix[i][0] == 0) {
                for (j in 1..matrix[i].lastIndex) {
                    matrix[i][j] = 0
                }
            }
        }

        //Check for Row, If any 0 found in 0th index
        //row mark entire column as 0
        for (j in 1..matrix[0].lastIndex) {
            if (matrix[0][j] == 0) {
                for (i in 1..matrix.lastIndex) {
                    matrix[i][j] = 0
                }
            }
        }

        //If 0th index row was 0 mark entire 1st row as zero
        if (isFirstRowZero) {
            for (j in 0..matrix[0].lastIndex) {
                matrix[0][j] = 0
            }
        }

        //If 0th index column was 0 mark entire 1st row as zero
        if (isFirstColumnZero) {
            for (i in 0..matrix.lastIndex) {
                matrix[i][0] = 0
            }
        }

        return matrix

    }

}