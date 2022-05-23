package com.example.algorithm

import linkedlist.ListNode


class ReturnLongestPalindromicSubString {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(ReturnLongestPalindromicSubString().longestPalindromicSubString("google"))

            val node =ListNode(2)
            val no = ListNode(3)
            no.next = node
            no.next?.next = ListNode(0)
            no.next?.next?.next = ListNode(-1)
            no.next?.next?.next?.next = node
            println(ReturnLongestPalindromicSubString().hasCycle(no))
        }
    }

    fun longestPalindromicSubString(string: String): String {
        val set = mutableSetOf<String>()
        set.contains("")
        val arr = Array(1) { "" }
        for (i in 0..string.lastIndex) {
            findPalindromicSubString(string, i, i, arr)
            findPalindromicSubString(string, i, i + 1, arr)
        }
        return arr[0]
    }

    fun findPalindromicSubString(input: String, s: Int, e: Int, arr: Array<String>) {
        var start = s
        var end = e
        while (start >= 0 && end < input.length && input[start] == input[end]) {
            val temp = input.substring(start, end + 1)
            if (temp.length > arr[0].length) {
                arr[0] = temp
            }
            end++
            start--
        }
    }


    fun isPalindromic(str: String): Boolean {
        val lIndex = str.lastIndex
        for (i in 0..lIndex / 2) {
            if (str[i] != str[lIndex - i]) {
                return false
            }
        }
        return true
    }


    fun hasCycle(head: ListNode?): Boolean {
        if(head!=null){
            val set = mutableSetOf<ListNode?>()

            var node: ListNode? = head

            while(node!=null){
                if(set.contains(node)){
                    return true
                }
                set.add(node)
                node = node?.next
            }

        }

        return false
    }
}