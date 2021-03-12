package com.example.tree;

import java.util.*;

public class BinaryTree {

    private BNode root;

    public BinaryTree() {
        root = null;
    }


    /**
     * Depth First Search [DFS]
     * <p>
     * PreOrder Traversal is traverse  [Root -- Left SubTree-- Right SubTree]
     *
     * @param root a BNode object
     */
    public void preOrderTraverse(BNode root) {


        if (root != null) {
            System.out.print(root.val + " ,");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    /**
     * Depth First Search [DFS]
     * <p>
     * Inorder Traversal is traverse [Left SubTree -- Root -- Right SubTree]
     *
     * @param root a BNode object
     */
    public void inOrderTraverse(BNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + " ,");
            inOrderTraverse(root.right);
        }
    }


    /**
     * Depth First Search [DFS]
     * <p>
     * PostOrder Traversal is traverse  [Left SubTree-- Right SubTree -- Root]
     *
     * @param root a BNode object
     */
    public void postOrderTraverse(BNode root) {

        if (root != null) {
            System.out.print(root.val + " ,");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }


    /**
     * Breadth First Search[BFS]
     * <p>
     * Level Order Traversal
     *
     * @param root a BNode object
     */
    public void levelOrderTraversal(BNode root) {
        System.out.println("\n\nLevel Order Traversal");
        System.out.println();

        if (root != null) {
            Queue<BNode> integerQueue = new LinkedList<>();
            integerQueue.add(root);
            while (!integerQueue.isEmpty()) {
                BNode node = integerQueue.poll();
                if (node.left != null) {
                    integerQueue.add(node.left);
                }
                if (node.right != null) {
                    integerQueue.add(node.right);
                }
                System.out.print(node.val + ", ");
            }
            System.out.println("\n");
        }
    }


    /**
     * Searching a value in Binary Tree
     *
     * @param value a integer value to Search
     */
    public boolean isAvailable(int value) {
        if (root == null) {
            System.out.println("Value not found as Tree hight is 0");
        } else {
            //First will do Level order traversal for searching the value
            Queue<BNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BNode node = queue.poll();
                if (node.val == value) {
                    System.out.println("Value " + value + " found !!");
                    return true;
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            System.out.println("Value not found !!");
        }
        return false;
    }


    public boolean add(int val) {
        if (root == null) {
            root = new BNode(val);
            System.out.println("Value :" + val + " Added Successfully !!");
            return true;
        } else {
            Queue<BNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BNode node = queue.poll();
                if (node.left == null) {
                    node.left = new BNode(val);
                    System.out.println("Value :" + val + " Added left of " + node.val + " Successfully !!");
                    return true;
                }

                if (node.right == null) {
                    node.right = new BNode(val);
                    System.out.println("Value :" + val + " Added right of " + node.val + " Successfully !!");
                    return true;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return false;
    }


    public boolean delete(int val) {
        if (root != null) {

            Queue<BNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {

                BNode node = queue.poll();

                if (node.val == val) {

                    node.val = getDeepestNode().val;

                    deleteDeepestNode();

                    return true;
                } else {

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
        }
        return false;
    }

    private BNode getDeepestNode() {
        Queue<BNode> queue = new LinkedList<>();
        BNode currentNode = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return currentNode;
    }

    //Delete deepest node
    public void deleteDeepestNode() {
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(root);
        BNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null && previousNode != null) {
                previousNode.right = null;
                return;
            } else if ((presentNode.right == null)) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }//end of while loop
    }//end of met


    public BNode getRoot() {
        return root;
    }

}
