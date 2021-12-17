package com.example.hashing;

import java.util.HashMap;
import java.util.LinkedList;

public class DirectChaining {

    private LinkedList<String>[] hashTable;

    public DirectChaining() {
        hashTable = new LinkedList[16];
    }


    public int simpleASCIIHashFunction(String x, int M) {
        char[] ch = x.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < ch.length; i++) {
            sum += ch[i];
        }
        return sum % M;
    }

    public void insert(String word){
        int index= simpleASCIIHashFunction(word, hashTable.length);
        if (hashTable[index]==null){
            LinkedList<String> hashVal = new LinkedList<>();
            hashVal.add(word);
            hashTable[index] = hashVal;
        }else{
            hashTable[index].add(word);
        }
        System.out.println("Insert successfully !!");

    }


    // display the hash table
    public void displayHashTable() {
        if(hashTable == null) {
            System.out.println("\nHashTable does not exits !");
            return;
        }else {
            System.out.println("\n---------- HashTable ---------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + ", key: " + hashTable[i]);

            }
        }
    } //end of method
}
