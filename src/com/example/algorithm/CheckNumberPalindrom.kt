package com.example.algorithm

class CheckNumberPalindrom {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(CheckNumberPalindrom().isPalindrome(1000021))
            println(CheckNumberPalindrom().isPalindrome(10))
            println(CheckNumberPalindrom().isPalindrome(1000001))
            println(CheckNumberPalindrom().isPalindrome(77000077))
            println(CheckNumberPalindrom().isPalindrome(70000077))
            println(CheckNumberPalindrom().isPalindrome(0))
            println(CheckNumberPalindrom().isPalindrome(-121))
        }
    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        } else if (x < 10) {
            return true
        } else {


            var num = x
            var deci = 10
            while (num>=deci) {
                    val last = num % 10
                    var first = num / 10
                    while (first >=deci) {
                        first /= 10
                    }

                    if (first%10 == last) {
                        num /= 10
                    } else {
                        return false
                    }
                    deci *= 10
                }
                return true

        }
    }
}