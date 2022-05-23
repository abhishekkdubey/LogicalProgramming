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

        avl.printTreeGraphically(avl.getRoot());

        System.out.println();
        System.out.println("---------------------------------");
        Node root = null;
        BalanceTree avl1= new BalanceTree();
        root = avl1.insert(root, 10);
        root = avl1.insert(root,20);
        root = avl1.insert(root,30);
        root = avl1.insert(root,40);
        root = avl1.insert(root,50);
        root = avl1.insert(root, 60);
        root = avl1.insert(root,70);
        root = avl1.insert(root,80);
        root = avl1.insert(root,90);
        root = avl1.insert(root,100);

        avl.printTreeGraphically(root);


        System.out.println(avl.traversing(AVL.Traverse.POST_ORDER));
    }
}
