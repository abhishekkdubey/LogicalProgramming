package com.example.tree.BST;

public class BSTMain {

    public static void main(String[] args) {
        BST bst= new BST();
        bst.insert(100);
        bst.insert(80);
        bst.insert(200);
        bst.insert(70);
        bst.insert(90);
        bst.insert(50);
        bst.insert(40);
        bst.insert(60);
        bst.insert(200);
        bst.insert(150);
        bst.insert(300);
        bst.insert(250);
        bst.insert(400);
//        bst.lavelOrderTraversal();

//        System.out.println("============PreOrder=========");
//        System.out.println();
//        bst.preOrderTraversal(bst.getRoot());
//        System.out.println();
//
//        System.out.println("============InOrder=========");
//        System.out.println();
//        bst.inOrderTraversal(bst.getRoot());
//        System.out.println();
//
//        System.out.println("============PostOrder=========");
//        System.out.println();
//        bst.postOrderTraversal(bst.getRoot());
//        System.out.println();
//
//
//
//        System.out.println("Searching for value 250 :"+bst.search(250));
//        System.out.println("Searching for value 245 :"+bst.search(245));
//
//        System.out.println("============Delete=========");
//        System.out.println("Delete 100: ");
//        bst.delete(100);
//        System.out.println("============PreOrder=========");
//        System.out.println();
//        bst.preOrderTraversal(bst.getRoot());
//        System.out.println();
//
//        System.out.println("Delete 144: ");
//        bst.delete(144);
//
//        System.out.println("============PreOrder=========");
//        System.out.println();
//        bst.preOrderTraversal(bst.getRoot());
//        System.out.println();

        System.out.println(bst.traversing(BST.Traverse.PRE_ORDER));
        System.out.println("=====================");
        System.out.println(bst.traversing(BST.Traverse.IN_ORDER));
        System.out.println("=====================");
        System.out.println(bst.traversing(BST.Traverse.POST_ORDER));
        System.out.println("=====================");
        System.out.println(bst.traversing(BST.Traverse.LEVEL_ORDER));


    }
}
