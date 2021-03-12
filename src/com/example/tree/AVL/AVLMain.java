package com.example.tree.AVL;

public class AVLMain {

    public static void main(String[] args) {
        AVL avl= new AVL();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);
        avl.insert(60);
        avl.insert(70);
        avl.insert(80);
        avl.insert(90);
        avl.insert(100);

        avl.printTreeGraphically();


        System.out.println(avl.traversing(AVL.Traverse.IN_ORDER));
    }
}
