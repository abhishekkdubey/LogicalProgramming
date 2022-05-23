package com.example.tree.algorithms

class DistanceBetweenTwoNodes {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val root = Node(1)
            root.left= Node(2)
            root.right = Node(3)
            root.left?.left = Node(4)
            root.left?.right = Node(5)
            root.right?.left = Node(6)
            root.right?.right = Node(7)
            root.right?.left?.right = Node(8)

            println(DistanceBetweenTwoNodes().distanceBetweenNodes(root, 4, 5))
            println(DistanceBetweenTwoNodes().distanceBetweenNodes(root, 3, 6))
            println(DistanceBetweenTwoNodes().distanceBetweenNodes(root, 3, 8))
            println(DistanceBetweenTwoNodes().distanceBetweenNodes(root, 2, 7))
            println(DistanceBetweenTwoNodes().distanceBetweenNodes(root, 2, 1))
        }
    }

    fun distanceBetweenNodes(root: Node, v1: Int, v2: Int): Int {

        val lowestCommonAncestor = getLowestCommonAncestor(root, v1, v2)

        val d1 = findDistance(lowestCommonAncestor, v1, 0)
        val d2 = findDistance(lowestCommonAncestor, v2, 0)

        return d1 + d2
    }


    fun findDistance(root: Node?, v: Int, distance: Int): Int {
        if (root == null) {
            return -1
        } else if (root.value == v) {
            return distance
        } else {
            val left = findDistance(root.left, v, distance + 1)
            if (left == -1) {
                return findDistance(root.right, v, distance + 1)
            }
            return left
        }
    }

    private fun getLowestCommonAncestor(root: Node?, v1: Int, v2: Int): Node? {

        if (root == null) {
            return null
        } else if (root.value == v1 || root.value == v2) {
            return root
        } else {
            val left = getLowestCommonAncestor(root.left, v1, v2)
            val right = getLowestCommonAncestor(root.right, v1, v2)

            if (right == null && left == null) {
                return null
            } else if (left != null && right != null) {
                return root
            } else if (right != null) {
                return getLowestCommonAncestor(root.right, v1, v2)
            } else {
                return getLowestCommonAncestor(root.left, v1, v2)
            }
        }


    }

    data class Node(val value: Int, var left: Node? = null, var right: Node? = null)
}

