package com.example.graph

import java.util.*
import kotlin.collections.HashSet

/**
 * 127. Word Ladder
Hard

7249

1598

Add to List

Share
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
 */
class WordLadder_127 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                WordLadder_127().wordLadder(
                    beginWord = "hit",
                    endWord = "cog",
                    wordList = mutableListOf("hot", "dot", "dog", "lot", "log", "cog")
                )
            )
            println(
                WordLadder_127().wordLadder(
                    beginWord = "hit",
                    endWord = "cog",
                    wordList = mutableListOf("hot", "dot", "dog", "lot", "log")
                )
            )

            println(
                WordLadder_127().ladderLength(
                    beginWord = "hit",
                    endWord = "cog",
                    wordList = mutableListOf("hot", "dot", "dog", "lot", "log", "cog")
                )
            )
            println(
                WordLadder_127().ladderLength(
                    beginWord = "hit",
                    endWord = "cog",
                    wordList = mutableListOf("hot", "dot", "dog", "lot", "log")
                )
            )
        }
    }

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val set: MutableSet<String> = HashSet<String>()
        var isPresent = false //Checks if endWord is present in Dict

        //Insert all words from Dict in myset
        //Insert all words from Dict in myset
        for (word in wordList) {
            if (endWord.compareTo(word) === 0) isPresent = true
            set.add(word) //Insert word in Dict
        }
        if (!isPresent) //endWord is not present in Dict
            return 0

        val q: Queue<String> = LinkedList<String>()
        q.add(beginWord)
        var depth = 0

        while (!q.isEmpty()) {
            depth += 1
            var lsize: Int = q.size //No of elements at a level
            while (lsize-- > 0) {
                val curr: String = q.poll()
                //check for all possible 1 depth words
                for (i in curr.indices)  //For each index
                {
                    val temp1 = StringBuilder(curr)
                    var c = 'a'
                    while (c <= 'z') {
                        temp1.setCharAt(i, c)
                        val temp = temp1.toString()
                        if (curr.compareTo(temp) == 0) {
                            ++c
                            continue  //Skip the same word
                        }
                        if (temp.compareTo(endWord) == 0) return depth + 1 //endWord found
                        if (set.contains(temp)) {
                            q.add(temp)
                            set.remove(temp)
                        }
                        ++c
                    }
                }
            }
        }
        return 0
    }


    fun wordLadder(beginWord: String, endWord: String, wordList: List<String>): Int {

        if (!wordList.contains(endWord)) {
            return 0
        }

        val set = HashSet<String>()
        set.addAll(wordList)

        val queue = LinkedList<String>()
        var depth = 0

        queue.add(beginWord)
        while (queue.isNotEmpty()) {
            depth++
            var qSize = queue.size
            while (qSize-- > 0) {
                val word = queue.poll()
                for (i in 0..word.lastIndex) {

                    val temp = StringBuilder(word)
                    var c = 'a'
                    while (c <= 'z') {
                        temp[i] = c
                        if (temp.toString() == word) {
                            c++
                            continue
                        }
                        if (temp.toString() == endWord) {
                            return depth+1
                        }
                        if (set.contains(temp.toString())) {
                            queue.add(temp.toString())
                            set.remove(temp.toString())
                        }
                        c++
                    }
                }
            }
        }
        return 0
    }


}