package com.example.tree

import com.example.tree.BST.Node
import java.util.*

class TreeTraversalIterative {

    fun preOrderTraversal(root: Node?) {
        if (root != null) {
            val stack: Stack<Node> = Stack<Node>()
            stack.push(root)
            println()
            print("[")
            while (stack.isNotEmpty()) {
                val temp = stack.pop()
                print(temp.value.toString().plus(", "))
                if (temp.right != null)
                    stack.push(temp.right)
                if (temp.left != null)
                    stack.push(temp.left)
            }
            print("]")
            println()
        }
    }


    fun inOrderTraversal(root: Node?) {
        if (root != null) {
            val stack: Stack<Node> = Stack<Node>()
            var current: Node? = root
            println()
            print("[")
            while (current != null || stack.isNotEmpty()) {

                while (current != null) {
                    stack.push(current)
                    current = current.left
                }


                current = stack.pop()
                print(current.value.toString().plus(", "))


                current = current?.right
            }
            print("]")
            println()

        }
    }


    fun postOrderTraversal(root: Node?) {

        if (root == null) {
            return
        }

        val stack: Stack<Node> = Stack()
        var current: Node? = root

        var previous: Node? = null;
        println()
        print("[")

        while (current != null || stack.isNotEmpty()) {
            if (current != null) {
                stack.push(current)
                current = current.left
            } else {
                current = stack.peek()
                if (current.right == null || current.right == previous) {
                    print(current.value.toString().plus(", "))
                    stack.pop()
                    previous = current
                    current = null
                } else {
                    current = current.right
                }
            }
        }
        print("]")
        println()


    }


}