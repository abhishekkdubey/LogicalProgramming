package com.example.tree.AVL;

public class BalanceTree {


    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (root.data >= value) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        int balance = height(root.left) - height(root.right);

        if (balance > 1) { // Left subtree is overloaded

            if (height(root.left.left) >= height(root.left.right)) { //Left -Left condition
                root = rightRotation(root);
            } else { //Left-Right Condition
                root.left = leftRotation(root.left);
                root = rightRotation(root);
            }
        } else if (balance < -1) { // Right sub tree is overloaded
            if (height(root.right.right) >= height(root.right.left)) { //Right-Right condition
                root = leftRotation(root);
            } else {
                root.right = rightRotation(root.right);
                root = leftRotation(root);
            }
        }
        return root;
    }


    public Node leftRotation(Node node) {
        Node rootNode = node.right;
        node.right = node.right.left;
        rootNode.left = node;
        return rootNode;

    }


    public Node rightRotation(Node node) {
        Node rootNode = node.left;
        node.left = node.left.right;
        rootNode.right = node;
        return rootNode;

    }


    int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            int left = height(node.left);
            int right = height(node.right);
            if (left > right) {
                return 1 + left;
            } else {
                return 1 + right;
            }
        }


    }


    public Node delete(Node root, int value) {
        if (root == null) {
            return null;
        } else if (root.data > value) {
            root.left = delete(root.left, value);
        } else if (root.data < value) {
            root.right = delete(root.right, value);
        } else {

            if (root.left != null && root.right != null) {
                Node temp = minimumNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        int balance = height(root.left) - height(root.right);
        if (balance > 1) { //Left sub tree is overloaded
            if (height(root.left.left) < height(root.left.right)) {
                root.left = leftRotation(root.left);
            }
            root = rightRotation(root);
        } else if (balance < -1) {// Right Subtree is overloaded
            if (height(root.right.right) < height(root.right.left)) {
                root.right = rightRotation(root.right);
            }
            root= leftRotation(root);
        }
        return root;
    }

    public Node minimumNode(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return minimumNode(node.left);
        }
    }


}
