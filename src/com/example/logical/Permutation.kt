package com.example.logical

class Permutation {


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val s = "ABC"
            val N = s.length;
            Permutation().backtrack(s, 0, N - 1)
        }
    }
    private fun backtrack(str: String, idx: Int, N: Int) {
        var s = str.toCharArray()
        if (idx == N) println(s) else {
            for (i in idx..N) {
                s = s.swap(idx, i)
                backtrack(String(s), idx + 1, N)
                s = s.swap(idx, i)
            }
        }
    }

    fun CharArray.swap(i: Int, j:Int): CharArray{
        val t = this[i]
        this[i] = this[j]
        this[j] = t
        return this
    }

}