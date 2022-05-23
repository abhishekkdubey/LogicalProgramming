package com.example.algorithm

/**
 * 763. Partition Labels
 *
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 *
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 *
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 *
 * Output: [10]
 *
 * Constraints:
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
class PartitionLabels_763 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(PartitionLabels_763().partitionLabels("ababcbacadefegdehijhklij"))
            println(PartitionLabels_763().partitionLabels("eccbbbbdec"))
            println(PartitionLabels_763().partitionLabels("eccbbbbdectrtrtrkrktrxyzv"))
            println(PartitionLabels_763().partitionLabels("e"))
        }
    }


    fun partitionLabels(s: String): List<Int> {


        val result = mutableListOf<Int>()

        val resultSubStr = mutableListOf<String>()

        val lastIndexes = Array(26) { -1 }

        //Store the last index of every character present in String
        for (i in 0..s.lastIndex) {
            lastIndexes[s[i] - 'a'] = i
        }


        var start = 0
        var end = 0

        for (i in 0..s.lastIndex) {
            end = maxOf(end, lastIndexes[s[i] - 'a'])
            if (end == i) {
                result.add(end - start + 1)
                resultSubStr.add(s.substring(start, end + 1))
                start = end + 1
            }
        }
        println(resultSubStr)

        return result
    }
}