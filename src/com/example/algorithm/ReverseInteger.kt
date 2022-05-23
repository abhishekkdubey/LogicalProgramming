package com.example.algorithm

import kotlin.math.abs

class ReverseInteger {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(ReverseInteger().getReverse(1534236469))
            println(ReverseInteger().getReverse(-2147483648))
            println(ReverseInteger().getReverse(-1212122))
            println(ReverseInteger().getReverse(0))
            println(ReverseInteger().getReverse(120))

        }
    }

    fun getReverse(v: Int): Int {

        if (v < 10 && v > -10) {
            return v
        }
        if (v>=Int.MAX_VALUE || v<= Int.MIN_VALUE){
            return 0
        }

        val isNegative = v < 0

        var loc = if (isNegative){v*-1}else{v}

        var result = 0


        while (loc > 9) {
            val mod = loc % 10
            result = result * 10 + mod
            loc /= 10
        }

        if(result>0 && Int.MAX_VALUE/result<10){
            return 0
        }
        result = result * 10 + loc

        return if (isNegative){
            (result*-1)
        }else{
            result
        }

    }



}