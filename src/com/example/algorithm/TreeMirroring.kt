package com.example.algorithm

import com.example.tree.BST.BST
import com.example.tree.BST.Node
import java.util.*

class TreeMirroring {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val bst = Node(10)
            bst.left = Node(8)
            bst.right = Node(12)
            bst.left.left = Node(6)
            bst.left.right = Node(9)
            bst.right.left = Node(11)
            bst.right.right = Node(14)
            TreeMirroring().treeMirror(bst)
        }
    }


    fun treeMirror(root: Node): Node {

        val queue = LinkedList<Node>()

        queue.add(root)
        while (queue.isNotEmpty()) {
            val n = queue.remove()
            val right = n.right
            if (n.left != null)
                queue.add(n.left)
            if (n.right != null)
                queue.add(n.right)
            n.right = n.left
            n.left = right
        }
        return root

    }
}