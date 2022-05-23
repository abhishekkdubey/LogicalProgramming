package com.example.practice;

/**
 * Write a function to add two positive numbers which is beyond the number range of compiler.
 *
 * "123456789098766555555" + "123456789098766555555"
 */
class SumOfTwoLargeNumber {


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println( SumOfTwoLargeNumber().sum("123", "123"))
        }
    }
    fun sum(num1: String, num2:String): String {

        var reminder = 0

        var s = ""

        var i = num1.lastIndex
        var j = num2.lastIndex

        while (i >= 0 && j >= 0) {
            val sum = (num1[i] - '0') + (num2[j] - '0') + reminder
            val h = sumHelper(sum, s)
            reminder = h.first
            s = h.second
            i--
            j--
        }

        while (i >= 0) {
            val sum = (num1[i] - '0') + reminder
            val h = sumHelper(sum, s)
            reminder = h.first
            s = h.second
            i--
        }


        while (j >= 0) {
            val sum = (num2[j] - '0') + reminder
            val h = sumHelper(sum, s)
            reminder = h.first
            s = h.second
            j--
        }


        if (reminder > 0) {
            s = reminder.toString() + s
        }

        return s
    }


    private fun sumHelper(sum:Int, s:String):Pair<Int, String> {
        return if (sum > 9) {
            Pair(sum / 10, (sum % 10).toString() + s)
        } else {
            Pair(0, sum.toString() + s)
        }
    }
}
