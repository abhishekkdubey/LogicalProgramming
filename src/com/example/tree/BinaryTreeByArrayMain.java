package com.example.tree;

public class BinaryTreeByArrayMain {


    public static void main(String[] args) {
        BinaryTreeByArray binaryTreeByArray= new BinaryTreeByArray(10);

        System.out.println(binaryTreeByArray.add(20));
        System.out.println(binaryTreeByArray.add(100));
        System.out.println(binaryTreeByArray.add(3));
        System.out.println(binaryTreeByArray.add(50));
        System.out.println(binaryTreeByArray.add(15));
        System.out.println(binaryTreeByArray.add(250));
        System.out.println(binaryTreeByArray.add(35));
        System.out.println(binaryTreeByArray.add(222));
        System.out.println(binaryTreeByArray.add(111));
        System.out.println(binaryTreeByArray.add(333));
        System.out.println(binaryTreeByArray.add(444));
        System.out.println(binaryTreeByArray.add(444));


        System.out.println("========DELETE=========");

        System.out.println();

        System.out.println("========TRAVERSE=========");
        System.out.println("PreOrder");
        binaryTreeByArray.preOrderTraversal(1);
        System.out.println();
        System.out.println("InOrder");
        binaryTreeByArray.inOrderTraversal(1);
        System.out.println();
        System.out.println("PostOrder");
        binaryTreeByArray.postOrderTraversal(1);
        System.out.println();
        System.out.println("LevelOrder");
        binaryTreeByArray.levelOrderTraversal();
        System.out.println();

        System.out.println(binaryTreeByArray.delete(111));
        System.out.println("LevelOrder");
        binaryTreeByArray.levelOrderTraversal();
        System.out.println();

        System.out.println(binaryTreeByArray.delete(3));
        System.out.println("LevelOrder");
        binaryTreeByArray.levelOrderTraversal();
        System.out.println();

        System.out.println(binaryTreeByArray.isAvailable(333));

    }

}
