package com.example.algorithm

class EditDistance {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(EditDistance().editDistanceToMatch("able", "atle"))
            println(EditDistance().editDistanceToMatch("table", "able"))
            println(EditDistance().editDistanceToMatch("unable", "stable"))
            println(EditDistance().editDistanceToMatch("Anshuman","Antihuman"))
            println(EditDistance().editDistanceToMatch("Anshuman", "Antihuman"))
            println(EditDistance().editDistanceToMatch("abcd", "kbadxr"))
            println(EditDistance().editDistanceToMatch("abad", "abac"))

        }

    }


    fun editDistanceToMatch(s1: String, s2: String, i1: Int = 0, i2: Int = 0): Int {

        if (i1 == s1.length) {
            return s2.length - i2
        }

        if (i2 == s2.length) {
            return s1.length - i1
        }
        if (s1[i1] == s2[i2]) {

            return editDistanceToMatch(s1, s2, i1 + 1, i2 + 1)
        }

        val c1 = 1 + editDistanceToMatch(s1, s2, i1 + 1, i2) //Perform insertion
        val c2 = 1 + editDistanceToMatch(s1, s2, i1, i2 + 1) // Perform deletion
        val c3 = 1 + editDistanceToMatch(s1, s2, i1 + 1, i2 + 1) //Perform Replacement

        return minOf(c1, c2, c3)

    }
}