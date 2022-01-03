package com.example.algorithm

class ActivitySelectionProblem {
    fun activitySelectionProblem(arr: Array<Triple<String, Int, Int>>): String {

        val sortedArray = arr.toList().sortedWith(compareBy { it.third })

        println("Sorted Array")
        for (a in sortedArray) {
            println("[${a.first}, ${a.second}, ${a.third}]")
        }

        val solution = StringBuilder()
        solution.append(sortedArray[0].first).append(", ")
        var tp: Triple<String?, Int?, Int> = sortedArray[0]


        for (i in 1 until sortedArray.size) {
            if (sortedArray[i].second >= tp.third) {
                tp = sortedArray[i]
                solution.append(tp.first).append(", ")
            }
        }
        return solution.toString()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tp1 = Triple("A1", 0, 6)
            val tp2 = Triple("A2", 3, 4)
            val tp3 = Triple("A3", 1, 2)
            val tp4 = Triple("A4", 5, 8)
            val tp5 = Triple("A5", 5, 7)
            val tp6 = Triple("A6", 8, 9)
            val arr: Array<Triple<String, Int, Int>> = arrayOf(tp1, tp2, tp3, tp4, tp5, tp6)

            for (a in arr) {
                println("[${a.first}, ${a.second}, ${a.third}]")
            }
            ActivitySelectionProblem().activitySelectionProblem(arr)
        }
    }
}