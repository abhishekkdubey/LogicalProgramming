package com.example.tree

/**
 * 230. Kth Smallest Element in a BST
 *
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 *
 * 0 <= Node.val <= 10^4
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */
class KthSmallestElementInBST_230 {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            val tree = TreeNode(3)
            tree.left = TreeNode(1)
            tree.right = TreeNode(4)
            tree.left?.right = TreeNode(2)

            println(KthSmallestElementInBST_230().kthSmallest(tree, 1))
        }
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val arr = IntArray(1) { 0 }
        val res = IntArray(1) { -1 }
        inroderTraversal(root, k, arr, res)
        return res[0]
    }


    fun inroderTraversal(root: TreeNode?, k: Int, counter: IntArray, res: IntArray) {

        if (root == null) {
            return
        }

        inroderTraversal(root.left, k, counter, res)
        if (k == counter[0] + 1) {
            counter[0] += 1
            res[0] = root.`val`
            return
        }
        counter[0] += 1
        inroderTraversal(root.right, k, counter, res)

    }

}