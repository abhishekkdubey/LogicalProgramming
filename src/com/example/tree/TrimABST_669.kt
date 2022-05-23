package com.example.tree

import com.example.tree.BST.Node
import java.util.*

/**
 * 669. Trim a Binary Search Tree
Medium

3972

226

Add to List

Share
Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.



Example 1:


Input: root = [1,0,2], low = 1, high = 2
Output: [1,null,2]
Example 2:


Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]


Constraints:

The number of nodes in the tree in the range [1, 10^4].
0 <= Node.val <= 10^4
The value of each node in the tree is unique.
root is guaranteed to be a valid binary search tree.
0 <= low <= high <= 10^4
 */
class TrimABST_669 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val node = TreeNode(3)
            node.left = TreeNode(0)
            node.right = TreeNode(4)
            node.left?.right = TreeNode(2)
            node.left?.right?.left = TreeNode(1)

            lavelOrderTraversal(TrimABST_669().trimBST(node, 1, 2))

        }

        fun lavelOrderTraversal(root: TreeNode?) {
            println("=============Level Order Traversal=================")
            val queue: Queue<TreeNode> = LinkedList()
            queue.add(root)
            while (!queue.isEmpty()) {
                val temp = queue.remove()
                print(temp.`val`.toString() + " ,")
                if (temp.left != null) {
                    queue.add(temp.left)
                }
                if (temp.right != null) {
                    queue.add(temp.right)
                }
            }
            println()
        }

    }

    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {

        var mainNode: TreeNode? = root ?: return null

        mainNode?.left = trimBST(mainNode?.left, low, high)
        mainNode?.right = trimBST(mainNode?.right, low, high)

        if (mainNode?.`val` !in low..high) {
            if (mainNode?.left != null && mainNode.right != null) {
                val node = minSubTreeNode(mainNode)
                val t = mainNode.`val`
                mainNode.`val` = node.`val`
                node.`val` = t
                mainNode.right = trimBST(mainNode.right, low, high)
            } else if (mainNode?.left != null) {
                mainNode = mainNode.left

            } else if (mainNode?.right != null) {
                mainNode = mainNode.right

            } else {
                mainNode = null
            }
        }
        return mainNode
    }

    fun minSubTreeNode(node: TreeNode): TreeNode {
        if (node.left == null) {
            return node
        }
        return minSubTreeNode(node.left!!)
    }


    data class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

}