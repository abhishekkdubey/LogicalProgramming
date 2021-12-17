package com.example.tree.AVL

import java.util.*
import kotlin.math.abs

class AVLKotlin {


    fun height(node: Node?): Int {
        if (node == null) {
            return -1
        }
        val left = height(node.left)
        val right = height(node.right)

        return 1 + if (left > right) {
            left
        } else {
            right
        }
    }


    fun isAVL(root: Node?): Boolean {

        if (root == null) {
            return true
        }
        val stack: Stack<Node> = Stack()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()

            if (abs(height(node.left) - height(node.right)) > 1) {
                return false
            }
            if (node.right != null) {
                stack.push(node.right)
            }
            if (node.left != null) {
                stack.push(node.left)
            }
        }
        return true

    }


}