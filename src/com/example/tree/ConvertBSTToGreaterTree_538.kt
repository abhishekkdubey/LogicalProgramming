package com.example.tree

import java.util.*
import kotlin.collections.LinkedHashMap

/**
 * 538. Convert BST to Greater Tree
 *
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * Example 2:
 *
 * Input: root = [0,null,1]
 * Output: [1,null,1]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -10^4 <= Node.val <= 10^4
 * All the values in the tree are unique.
 * root is guaranteed to be a valid binary search tree.
 *
 *
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
class ConvertBSTToGreaterTree_538 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val tree = TreeNode(4)
            tree.left = TreeNode(1)
            tree.right = TreeNode(6)
            tree.left?.left = TreeNode(0)
            tree.left?.right = TreeNode(2)
            tree.left?.right?.right = TreeNode(3)
            tree.right?.left = TreeNode(5)
            tree.right?.right = TreeNode(7)
            tree.right?.right?.right = TreeNode(8)
            ConvertBSTToGreaterTree_538().convertBST(tree)

        }
    }

    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val map = LinkedHashMap<Int, TreeNode>()

        traverseBST(root, map)
        val keys = map.keys.toList()
        var prev = 0
        for(k in keys.lastIndex downTo 0){
            map[keys[k]]?.let {  it.`val` = keys[k]+prev}
            prev += keys[k]
        }

        return root
    }

    private fun traverseBST(root: TreeNode?, map: LinkedHashMap<Int, TreeNode>) {
        if (root == null) {
            return
        }
        val l = LinkedList<Int>()
        l.poll()
        traverseBST(root.left, map)
        map[root.`val`] = root
        traverseBST(root.right, map)
    }


}