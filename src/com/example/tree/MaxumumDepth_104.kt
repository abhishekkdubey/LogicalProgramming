package com.example.tree


class MaxumumDepth_104 {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val root = TreeNode(3)
            root.left = TreeNode(9)
            root.right = TreeNode(20)
            root.right?.left = TreeNode(15)
            root.right?.right = TreeNode(7)
            root.left?.left = TreeNode(18)
            root.left?.right = TreeNode(11)
            root.left?.left?.left = TreeNode(17)
            root.left?.left?.right = TreeNode(21)

            println(MaxumumDepth_104().maxDepth(root))
        }

    }

    fun maxDepth(root: TreeNode?): Int {

        if (root==null){
            return 0
        }

        val left = 1+maxDepth(root.left)
        val right = 1+maxDepth(root.right)

        return maxOf(left, right)
    }


}
data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

