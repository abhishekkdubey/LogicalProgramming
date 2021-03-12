package com.example.tree.AVL;

import javax.swing.*;
import java.util.*;

public class AVL {


    private Node root;

    private boolean isAvailable;

    public AVL() {
        this.root = null;
    }


    public boolean search(int val) {
        search(root, val);
        if (isAvailable) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }


    private Node search(Node root, int val) {
        if (root == null) {
            return null;
        } else if (val == root.data) {
            isAvailable = true;
            return root;
        } else if (val > root.data) {
            return search(root.right, val);
        } else {
            return search(root.left, val);
        }
    }

    enum Traverse {PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER}

    public List<Integer> traversing(Traverse traverse) {
        switch (traverse) {
            case PRE_ORDER:
                return preOrderTraversal(root);
            case IN_ORDER:
                return inOrderTraversal(root);
            case POST_ORDER:
                return postOrderTraversal(root);
            case LEVEL_ORDER:
                return levelOrderTraversal(root);
            default:
                return null;
        }
    }

    private List<Integer> levelOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node t = q.remove();
            res.add(t.data);
            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }
        }
        return res;
    }

    private List<Integer> postOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();

        Node current = root;
        Stack<Node> s = new Stack<>();
        while (true) {
            while (current != null) {
                s.add(current);
                s.add(current);
                current = current.left;
            }

            if (s.isEmpty()) {
                return res;
            }

            current = s.pop();

            if (!s.isEmpty() && current == s.peek()) {
                current = current.right;
            } else {
                res.add(current.data);
                current = null;
            }
        }
    }

    private List<Integer> inOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node current = root;
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.add(current);
                current = current.left;
            }

            current = s.pop();
            res.add(current.data);
            current = current.right;
        }


        return res;
    }

    private List<Integer> preOrderTraversal(Node root) {

        List<Integer> res = new ArrayList<>();

        Stack<Node> s = new Stack<>();
        if (root != null) {
            s.push(root);
        }
        Node current;
        while (!s.isEmpty()) {
            current = s.pop();
            res.add(current.data);
            if (current.right != null) {
                s.push(current.right);
            }
            if (current.left != null) {
                s.push(current.left);
            }
        }
        return res;
    }


    public void insert(int val) {
        root = insert(root, val);


    }

    private Node insert(Node currentNode, int val) {

        if (currentNode == null) {
            System.out.println("Successfully inserted " + val + " in AVL tree");
            return new Node(val);
        } else if (val <= currentNode.data) {
            currentNode.left = insert(currentNode.left, val);
        } else {
            currentNode.right = insert(currentNode.right, val);
        }

        int balance = balance(currentNode.left, currentNode.right);
        if (balance > 1) {//If Left Subtree is overloaded
            //Left-Left Condition
            if (balance(currentNode.left.left, currentNode.left.right) > 0) {
                currentNode = rightRotate(currentNode);
            } else {//Left-Right Condition
                currentNode.left = leftRotate(currentNode.left);
                currentNode = rightRotate(currentNode);
            }
        } else if (balance < -1) {//If Right Subtree is overloaded
            if (balance(currentNode.right.right, currentNode.right.left) > 0) {
                //Right-Right Condition
                currentNode = leftRotate(currentNode);
            } else {//Right-Left Condition
                currentNode.right = rightRotate(currentNode.right);
                currentNode = leftRotate(currentNode);
            }
        }

        if (currentNode.left != null) {
            currentNode.left.height = calculateHeight(currentNode.left);
        }
        if (currentNode.right != null) {
            currentNode.right.height = calculateHeight(currentNode.right);
        }

        currentNode.height = calculateHeight(currentNode);

        return currentNode;
    }

    private int balance(Node left, Node right) {

        if (left == null && right == null) {
            return 0;
        } else if (left == null) {
            return -1 * (right.height + 1);
        } else if (right == null) {
            return left.height + 1;
        } else {
            return (left.height - right.height);
        }
    }


    private Node rightRotate(Node node) {
        Node rootNode = node.left;
        node.left = node.left.right;
        rootNode.right = node;
        node.height = calculateHeight(node);
        rootNode.height = calculateHeight(rootNode);
        return rootNode;
    }

    private Node leftRotate(Node node) {
        Node rootNode = node.right;
        node.right = node.right.left;
        rootNode.left = node;
        rootNode.height = calculateHeight(rootNode);
        node.height = calculateHeight(node);

        return rootNode;
    }


    private int calculateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(
                node.left != null ? node.left.height : -1,
                node.right != null ? node.right.height : -1);
    }


    public void printTreeGraphically() {
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        int CurrentLevel = 1;
        boolean previousLevelWasAllNull = false;
        queue.add(root);
        level.add(1);

        System.out.println("\nPrinting Level order traversal of Tree...");
        if (root == null) {
            System.out.println("Tree does not exists !");
            return;
        }

        while (!queue.isEmpty()) {
            if (CurrentLevel == level.peek()) { //if we are in the same level
                if (queue.peek() == null) {
                    queue.add(null);
                    level.add(CurrentLevel + 1);
                } else {
                    if (queue.peek().left != null) {
                        queue.add(queue.peek().left);
                        level.add(CurrentLevel + 1);
                    }
                    if (queue.peek().right != null) {
                        queue.add(queue.peek().right);
                        level.add(CurrentLevel + 1);
                    }
                    previousLevelWasAllNull = false;
                }
                System.out.print(queue.remove() + "  ");
                level.remove();
            } else { //level has changed
                System.out.println("\n");
                CurrentLevel++;
                if (previousLevelWasAllNull == true) {
                    break;
                }
                previousLevelWasAllNull = true;
            }
        }//end of loop
    }//end of method


    public Node deleteNode(Node root, int val) {
        if (root == null) {
            System.out.println("Node not found!!");
            return null;
        } else if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left != null && root.right != null) {
                Node min = minimumRightNode(root.right);
                root.data= min.data;
                root.right = deleteNode(root.right, root.data);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            }

        }

        return root;
    }

    private Node minimumRightNode(Node right) {
        if (right.left == null) {
            return right;
        } else {
            return minimumRightNode(right.left);
        }
    }
}
