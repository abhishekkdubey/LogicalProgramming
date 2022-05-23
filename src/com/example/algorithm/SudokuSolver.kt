package com.example.algorithm

import java.util.*

class SudokuSolver {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sudoko = arrayOf(
                intArrayOf(3, 0, 6, 5, 0, 8, 4, 0, 0),
                intArrayOf(5, 2, 0, 0, 0, 0, 0, 0, 0),
                intArrayOf(0, 8, 7, 0, 0, 0, 0, 3, 1),
                intArrayOf(0, 0, 3, 0, 1, 0, 0, 8, 0),
                intArrayOf(9, 0, 0, 8, 6, 3, 0, 0, 5),
                intArrayOf(0, 5, 0, 0, 9, 0, 6, 0, 0),
                intArrayOf(1, 3, 0, 0, 0, 0, 2, 5, 0),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 7, 4),
                intArrayOf(0, 0, 5, 2, 0, 6, 3, 0, 0)
            )
            SudokuSolver().sudokuSolver(sudoko).hashCode()

        }
    }


    fun sudokuSolver(board: Array<IntArray>, i: Int = 0, j: Int = 0) {

        if (i == board.size) {
            printSudoko(board)

        } else {

            val ni: Int
            val nj: Int

            if (j == board[0].lastIndex) {
                ni = i + 1
                nj = 0
            } else {
                ni = i
                nj = j + 1
            }

            if (board[i][j] != 0) {
                sudokuSolver(board, ni, nj)
            } else {
                for (po in 1..9) {
                    if (isValid(board, i, j, po)) {
                        board[i][j] = po
                        sudokuSolver(board, ni, nj)
                        board[i][j] = 0
                    }
                }
            }
        }

    }

    private fun isValid(board: Array<IntArray>, i: Int, j: Int, po: Int): Boolean {


        for (p in 0..8) {
            if (board[p][j] == po) {
                return false
            }
        }

        for (q in 0..8) {
            if (board[i][q] == po) {
                return false
            }
        }

        val subi = (i / 3) * 3
        val subj = (j / 3) * 3

        for (p in 0..2) {
            for (q in 0..2) {
                if (board[subi + p][subj + q] == po) {
                    return false
                }
            }
        }

        return true
    }

    private fun printSudoko(board: Array<IntArray>) {
        println(board.forEach { it ->
            run {
                print("[")
                it.forEach {
                    print(" $it ")
                }
                print("]")
                println()
            }
        })
    }
}


fun main() {
    val node = TreeNode(2)
    node.left = TreeNode(1)
    node.right = TreeNode(4)

    val node2 = TreeNode(1)
    node2.left = TreeNode(0)
    node2.right = TreeNode(3)

    println(getAllElements(root1 = null, root2 = node2))

}

fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {


    val list1 = mutableListOf<Int>()
    val stack1 = Stack<TreeNode>()

    var r1 = root1

    while (r1 != null || stack1.size > 0) {
        while (r1 != null) {
            stack1.push(r1)
            r1 = r1.left
        }

        r1 = stack1.pop()
        list1.add(r1.`val`)

        r1 = r1.right
    }

    val list2 = mutableListOf<Int>()
    val stack2 = Stack<TreeNode>()

    var r2 = root2

    while (r2 != null || stack2.size > 0) {
        while (r2 != null) {
            stack2.push(r2)
            r2 = r2.left
        }

        r2 = stack2.pop()
        list2.add(r2.`val`)

        r2 = r2.right
    }


    val result = mutableListOf<Int>()

    var i = 0

    var j = 0

    while (i < list1.size && j < list2.size) {
        if (list1[i] < list2[j]) {
            result.add(list1[i++])
        } else {
            result.add(list2[j++])
        }
    }

    while (i < list1.size) {
        result.add(list1[i++])
    }

    while (j < list2.size) {
        result.add(list2[j++])
    }
    return result

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}