package com.example.tree.AVL;

public class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }


    @Override
    public String toString() {
        return data + "";
    }//end of method
}
