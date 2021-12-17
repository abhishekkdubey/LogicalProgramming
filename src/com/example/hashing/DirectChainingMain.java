package com.example.hashing;

public class DirectChainingMain {

    public static void main(String[] args) {
        DirectChaining directChaining= new DirectChaining();
        directChaining.insert("The");
        directChaining.insert("quick");
        directChaining.insert("brown");
        directChaining.insert("fox");
        directChaining.insert("over");
        directChaining.insert("lazy");
        directChaining.displayHashTable();

        directChaining.insert("fox"); // use for showing collision
        directChaining.displayHashTable();

        directChaining.insert("fox");
        directChaining.displayHashTable();

        directChaining.insert("fox");
        directChaining.displayHashTable();

        directChaining.insert("fox");
        directChaining.displayHashTable();
    }
}
