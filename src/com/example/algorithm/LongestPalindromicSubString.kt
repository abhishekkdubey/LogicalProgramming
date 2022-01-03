package com.example.algorithm

class LongestPalindromicSubString {


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(LongestPalindromicSubString().longestPalindromicSubString("testss", 0, 5))
        }
    }


    fun longestPalindromicSubString(s: String, l: Int, r: Int): Int{

        if (l>r){
            return 0
        }
        if (l==r){
            return 1
        }

        var c1 =0
        if (s[l]==s[r]){
            val remaining = r-l-1
            if (remaining == longestPalindromicSubString(s, l+1, r-1)){
                c1 = remaining+2
            }
        }
        val c2 = longestPalindromicSubString(s, l, r-1)
        val c3 = longestPalindromicSubString(s, l+1, r)

        return maxOf(c1, c2, c3)
    }

}