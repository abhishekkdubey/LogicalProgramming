package com.example.algorithm.string

class FindAnagram {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(FindAnagram().findAnagrams("abab", "ab"))
            println(FindAnagram().findAnagrams("cbaebabacd", "abc"))
        }
    }

    fun findAnagrams(s: String, p: String): List<Int> {

        val result = ArrayList<Int>()

        val cArr = IntArray(26) { 0 }

        for (i in 0..p.lastIndex) {
            cArr[p[i] - 'a'] = cArr[p[i] - 'a'] + 1
        }

        var copy = cArr.clone()
        for (i in 0..(s.lastIndex - p.lastIndex)) {

            for (j in 0..p.lastIndex) {
                copy[s[i + j] - 'a'] = copy[s[i + j] - 'a'] - 1
            }
            if (isAllZero(copy)) {
                result.add(i)
            }
            copy = cArr.clone()
        }


        return result
    }

    fun isAllZero(arr: IntArray): Boolean {
        return !arr.any { it != 0 }
    }

}