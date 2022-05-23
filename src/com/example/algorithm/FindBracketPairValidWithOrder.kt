package com.example.algorithm

import java.util.*

class FindBracketPairValidWithOrder {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(FindBracketPairValidWithOrder().isValid("(()){}[]"))
            println(FindBracketPairValidWithOrder().isValid("(()"))
            println(FindBracketPairValidWithOrder().isValid("[(()){}[]]"))
            println(FindBracketPairValidWithOrder().isValid("[{}]]"))

        }
    }

    fun isValid(input: String): Boolean {
        val sL = '('
        val sR = ')'
        val mL = '{'
        val mR = '}'
        val lL = '['
        val lR = ']'

        val stack = Stack<Char>()

        if (input[0] == sL || input[0] == mL || input[0] == lL) {
            stack.push(input[0])
        } else {
            return false
        }

        for (i in 1..input.lastIndex) {
            if (stack.isNotEmpty() &&
                ((input[i] == sR && stack.peek() == sL)
                        || (input[i] == mR && stack.peek() == mL)
                        || (input[i] == lR && stack.peek() == lL)
                        )
            ) {
                stack.pop()
            } else if (input[i] == sL || input[i] == mL || input[i] == lL) {
                stack.push(input[i])
            } else {
                return false
            }
        }
        return stack.isEmpty()
    }
}