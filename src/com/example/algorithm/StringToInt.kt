package com.example.algorithm

class StringToInt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(StringToInt().myAtoi("-4193 with words"))
            println(StringToInt().myAtoi("-2147483648 with words"))
            println(StringToInt().myAtoi("2147483648"))
            println(StringToInt().myAtoi("-91283472332 with words"))
            println(StringToInt().myAtoi("00000-42a123"))
        }
    }

    fun myAtoi(s: String?): Int {
        var res = 0
        if (s == null || s.isEmpty()) {
            return 0
        }

        var multiplier = 1
        val t = s.trim()
        if (t.isEmpty()) {
            return 0
        }

        var start = 0
        if (t[0] == '-') {
            multiplier = -1
            start = 1
        } else if (t[0] == '+') {
            start = 1
        }

        for (i in start..t.lastIndex) {
            if (t[i].toInt() !in 48..57) {
                return res * multiplier
            }
            res = if (res == 0 || Int.MAX_VALUE / res >= 10) {
                val x = (res.toLong() * 10) + (t[i].toInt() - 48)
                if (x * multiplier >= Int.MAX_VALUE) {
                    return Int.MAX_VALUE
                } else if (x * multiplier <= Int.MIN_VALUE) {
                    return Int.MIN_VALUE
                } else {
                    x.toInt()
                }
            } else {
                return if (multiplier == -1) {
                    Int.MIN_VALUE
                } else Int.MAX_VALUE
            }
        }
        return res * multiplier
    }
}