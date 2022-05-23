package com.example.general

import java.lang.StringBuilder
import java.util.*
import kotlin.math.min

class TestKotlin {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(' '.toInt())

            println('a'.toInt())
            println('z'.toInt())
            println('A'.toInt())
            println('Z'.toInt())

            println(TestKotlin().detectCapitalUse("USA"))
            println(TestKotlin().detectCapitalUse("Google"))
            println(TestKotlin().detectCapitalUse("GooglE"))
            println(TestKotlin().detectCapitalUse("google"))
            println(TestKotlin().detectCapitalUse("GooGle"))
            println(TestKotlin().detectCapitalUse("G0ogle"))
            println(TestKotlin().sol(mutableListOf(25, 2, 3, 57, 38, 41)))
            println(TestKotlin().stringSubProblem("abbaaaac"))
        }

    }

    fun detectCapitalUse(word: String): Boolean {
        if(word[0].toInt() !in 65..90){
            return false
        }else{
            var allCaps = false
            var allSmall = false
            for(i in 1..word.lastIndex){
                if(word[i].toInt() in 65..90 ){
                    allCaps = true
                }else{
                    allSmall = true
                }
                if (allSmall && allCaps){
                    return false
                }
            }
            return true
        }
    }

    fun stringSubProblem(input: String): String{
        val sb= StringBuilder("")
        val stack = Stack<Char>()

        var index = 0
        while(index<input.length){
            if (stack.isEmpty() || stack.peek()== input[index]){
                stack.push(input[index])
            }else{
               sb.append(""+stack.size+""+stack.peek())
                stack.clear()
                stack.push(input[index])
            }
            index++
        }
        if (!stack.isEmpty()){
            sb.append(""+stack.size+""+stack.peek())
            stack.clear()
        }

        return sb.toString()

    }


    fun sol(a: MutableList<Int>): MutableList<Int> {

        var map = mutableMapOf<Int, Int>()

        for (i in 0..9) {
            map[i] = 0
        }

        for (num in a) {
            var temp = num
            while (temp > 0) {
                val mod = temp % 10
                map[mod] = map[mod]!!.plus(1)
                temp /= 10
            }
        }
        var max = map[0]!!
        for (i in 1..9) {
            if (max < map[i]!!) {
                max = map[i]!!
            }
        }


    return map.filter { it.value==max}.keys.toMutableList()


}

}