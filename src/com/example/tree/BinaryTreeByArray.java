package com.example.tree;

public class BinaryTreeByArray {

    private int[] arr;
    private int lastUsedIndex;

    public BinaryTreeByArray(int size) {
        arr = new int[size + 1];
        lastUsedIndex = 0;
    }


    public boolean add(int val) {
        if (lastUsedIndex < arr.length - 1) {
            lastUsedIndex++;
            arr[lastUsedIndex] = val;
            return true;
        }
        System.out.println("Array is full!!");
        return false;
    }


    public boolean isAvailable(int val) {
        if (arr != null) {
            for (int i = 0; i <= lastUsedIndex; i++) {
                if (arr[i] == val) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean delete(int val) {
        if (arr != null) {
            for (int i = 1; i <= lastUsedIndex; i++) {
                if (arr[i] == val) {
                    if (i!=lastUsedIndex){
                        arr[i] = arr[lastUsedIndex];
                        arr[lastUsedIndex] =0;
                    }else {
                        arr[i] = 0;
                    }
                    lastUsedIndex--;
                    return true;
                }
            }
        }
        return false;
    }

    public void preOrderTraversal(int index) {

        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + ", ");
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);

    }

    public void inOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        System.out.print(arr[index] + ", ");
        preOrderTraversal(index * 2 + 1);

    }

    public void postOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);
        System.out.print(arr[index] + ", ");

    }

    public void levelOrderTraversal() {
        if (arr != null)
            for (int i = 1; i <= lastUsedIndex; i++) {
                System.out.print(arr[i] + ", ");

            }


    }

}
