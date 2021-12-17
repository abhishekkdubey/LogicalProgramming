package com.example.tree.BST;

import java.util.*;

public class BST {


    protected Node rootNode;


    public BST() {
        rootNode = null;
    }

    public Node getRoot() {
        return rootNode;
    }

    public void insert(int val) {
        rootNode = insertion(rootNode, val);
    }

    private Node insertion(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (val <= root.value) {
            root.left = insertion(root.left, val);
        } else {
            root.right = insertion(root.right, val);
        }
        return root;
    }


    enum Traverse {PRE_ORDER, IN_ORDER, POST_ORDER, LEVEL_ORDER}

    public List<Integer> traversing(Traverse traverse) {
        switch (traverse) {
            case PRE_ORDER:
                return preOrderTraversalIterative(rootNode);
            case IN_ORDER:
                return inOrderTraversalIterative(rootNode);
            case POST_ORDER:
                return postOrderTraversalIterative(rootNode);
            case LEVEL_ORDER:
                return levelOrderTraversalIterative(rootNode);
            default:
                return null;
        }
    }

    private List<Integer> preOrderTraversalIterative(Node root) {
        if (root == null) {
            return null;
        } else {
            List<Integer> result = new ArrayList<>();
            Stack<Node> s = new Stack<>();
            s.push(root);
            while (!s.isEmpty()) {
                Node temp = s.pop();
                result.add(temp.value);
                if (temp.right != null) {
                    s.push(temp.right);
                }
                if (temp.left != null) {
                    s.push(temp.left);
                }
            }
            return result;
        }
    }

    private List<Integer> inOrderTraversalIterative(Node root) {
        if (root == null) {
            return null;
        } else {
            List<Integer> result = new ArrayList<>();

            Stack<Node> s = new Stack<>();
            Node current = root;

            while (current != null || s.size() > 0) {
                while (current != null) {
                    s.push(current);
                    current = current.left;
                }
                current = s.pop();
                result.add(current.value);

                current = current.right;
            }
            return result;
        }
    }


    private List<Integer> postOrderTraversalIterative(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if(stack.empty()) return res;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root) root = root.right;

            else {

                res.add(root.value); root = null;
            }
        }
    }

    private List<Integer> levelOrderTraversalIterative(Node root) {
        List<Integer> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            Node t = q.remove();
            res.add(t.value);
            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }
        }
        return res;
    }


    public boolean search(int val) {
        return isAvailable(rootNode, val);
    }

    private boolean isAvailable(Node root, int val) {
        if (root == null) {
            return false;
        } else if (root.value == val) {
            return true;
        } else if (val < root.value) {
            return isAvailable(root.left, val);
        } else {
            return isAvailable(root.right, val);
        }
    }


    public void lavelOrderTraversal() {

        System.out.println("=============Level Order Traversal=================");
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.value + " ,");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        System.out.println();

    }


    public void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value + ", ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + ", ");
            inOrderTraversal(root.right);
        }
    }

    public void postOrderTraversal(Node root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + ", ");
        }
    }

    public void delete(int val) {
        System.out.println("\n\nDeleting " + val + " from BST...");
        deleteNode(rootNode, val);
    }

    private Node deleteNode(Node root, int val) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        } else if (val > root.value) {
            root.right = deleteNode(root.right, val);
        } else if (val < root.value) {
            root.left = deleteNode(root.left, val);
        } else {
            if (root.left != null && root.right != null) {
                Node minRightSubTree = mininumSubTreeNode(root.right);
                root.value = minRightSubTree.value;
                root.right = deleteNode(root.right, minRightSubTree.value);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;
    }

    private Node mininumSubTreeNode(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return mininumSubTreeNode(node.left);
        }
    }


}
