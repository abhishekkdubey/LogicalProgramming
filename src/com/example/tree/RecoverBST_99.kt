package com.example.tree

/**
 * 99. Recover Binary Search Tree
 *
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 *
 * Example 2:
 *
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 1000].
 * -2^31 <= Node.val <= 2^31 - 1
 *
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */
class RecoverBST_99 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val tree = TreeNode(5)
            tree.left = TreeNode(8)
            tree.right = TreeNode(9)
            tree.left?.left = TreeNode(2)
            tree.left?.right = TreeNode(4)
            tree.right?.left = TreeNode(3)
            tree.right?.right = TreeNode(10)
            RecoverBST_99().inorderTraversal(
                tree
            )

            println(tree)
        }
    }


    fun inorderTraversal(root: TreeNode?) {


        val first = Array<TreeNode?>(1) { null }
        val second = Array<TreeNode?>(1) { null }
        val prev = Array<TreeNode?>(1) { null }
        inorderTraversal(
            root, first, second, prev
        )
        if (first[0] != null && second[0] != null) {
            val temp = first[0]!!.`val`
            first[0]!!.`val` = second[0]!!.`val`
            second[0]?.`val` = temp
        }
    }

    private fun inorderTraversal(
        root: TreeNode?,
        first: Array<TreeNode?>,
        second: Array<TreeNode?>,
        prev: Array<TreeNode?>
    ) {
        if (root == null) {
            return
        }
        inorderTraversal(root.left, first, second, prev)
        if ((prev[0]?.`val` ?: Int.MIN_VALUE) > root.`val`) {
            if (first[0] == null) {
                first[0] = prev[0]
            }
            second[0] = root
        }
        prev[0] = root
        inorderTraversal(root.right, first, second, prev)
    }


}