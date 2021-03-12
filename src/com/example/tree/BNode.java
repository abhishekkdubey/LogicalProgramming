package com.example.tree;

public class BNode {

    public BNode left;
    public BNode right;
    int val;

    BNode(int val) {
        this.val = val;
        left = right = null;
    }
}
