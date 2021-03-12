package com.example.tree;

public class BinaryTreeMain {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();


        binaryTree.add(20);
        binaryTree.add(100);
        binaryTree.add(3);
        binaryTree.add(50);
        binaryTree.add(15);
        binaryTree.add(250);
        binaryTree.add(35);
        binaryTree.add(222);


        System.out.println("===========TRAVERSAL================");
        System.out.println("\npreOrderTraverse");
        binaryTree.preOrderTraverse(binaryTree.getRoot());
        System.out.println("\ninOrderTraverse");
        binaryTree.inOrderTraverse(binaryTree.getRoot());
        System.out.println("\npostOrderTraverse");
        binaryTree.postOrderTraverse(binaryTree.getRoot());
        binaryTree.levelOrderTraversal(binaryTree.getRoot());


        binaryTree.isAvailable(100);
        binaryTree.isAvailable(35);
        binaryTree.isAvailable(20);

        binaryTree.isAvailable(255);

        System.out.println("\ninOrderTraverse");
        binaryTree.inOrderTraverse(binaryTree.getRoot());
        System.out.println();

        System.out.println("Delete 20 "+binaryTree.delete(20));
        System.out.println("\ninOrderTraverse");
        binaryTree.inOrderTraverse(binaryTree.getRoot());
        System.out.println();

    }
}
