package com.example.algorithm

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.test.currentStackTrace

class TrieStructure {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val trie = TrieNodeKtx()

            TrieStructure().insertIntoTrie(trie, "answer")
            TrieStructure().insertIntoTrie(trie, "any")
            TrieStructure().insertIntoTrie(trie, "bye")
            TrieStructure().insertIntoTrie(trie, "their")
            TrieStructure().insertIntoTrie(trie, "there")
            println("Node Inserted Successfully!!")

        }
    }

    fun insertIntoTrie(root: TrieNodeKtx, str: String) {
        var current = root

        for (i in 0..str.lastIndex) {
            var node = current.children[str[i]]
            if (node == null) {
                node = TrieNodeKtx()
                node.parent = current
                current.children[str[i]] = node

            }
            current = node
        }
        current.endOfWord = true
    }

    fun searchForString(root: TrieNodeKtx, string: String): Boolean {
        var current = root
        for (i in 0..string.lastIndex) {
            val node = current.children[string[i]] ?: return false
            current = node
        }
        return current.endOfWord
    }

    fun getSuggestionForString(string: String): List<String> {
        return emptyList()
    }


    fun getAllWords(root: TrieNodeKtx): List<String> {

        var current = root

        val cArr = current.children.keys
        val words = ArrayList<String>()
        for (c in cArr) {
            getAllWordsHelper(current.children[c], java.lang.StringBuilder("$c"), words)
        }
        return words
    }

    fun getAllWordsHelper(root: TrieNodeKtx?, sb: StringBuilder, words: ArrayList<String>) {


    }
}
    data class TrieNodeKtx(
        var children: HashMap<Char, TrieNodeKtx> = HashMap(),
        var endOfWord: Boolean = false,
        var parent: TrieNodeKtx? = null
    )
