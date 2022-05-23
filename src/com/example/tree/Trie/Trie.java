package com.example.tree.Trie;

import java.util.*;

public class Trie {


    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }


    public void insert(String val) {
        TrieNode current = root;
        for (int i = 0; i < val.length(); i++) {
            char ch = val.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
        System.out.println("Successfully inserted " + val + " in Trie !!");
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.children.get(word.charAt(i));
            if (node == null) {
                System.out.println("Word: " + word + " does not exists in Trie !");
                return false;
            }
            current = node;
            if (current.endOfWord) {
                System.out.println("Word: " + word + " exists in Trie !"); //CASE#2 -- Word exists in Trie
            } else {//CASE#3 -- Current word is a prefix of another word. But this word does not exists
//                 System.out.println("Word: " + word + " does not exists in Trie ! But this is a Prefix of another Word !");
            }

        }
        return current.endOfWord;
    }

    public void delete(String word) {
        if (search(word) == true) {
            delete(root, word, 0);
        }
    }

    //Return true if parent node need to delete from mapping
    private boolean delete(TrieNode parent, String word, int index) {

        // CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
        // CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
        // CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
        // CASE#4 -- No one is dependent on this Word (BCDE, BCDE)

        char ch = word.charAt(index);
        TrieNode node = parent.children.get(ch);

        if (node.children.size() > 1) {
            System.out.println("Entering Case #1");
            delete(node, word, index + 1);
            return false;
        }

        if (index == word.length() - 1) {
            System.out.println("Entering case #2");
            if (node.children.size() > 1) {
                node.endOfWord = false;
                return false;
            } else {
                System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
                parent.children.remove(ch);
                return true;
            }
        }

        if (node.endOfWord) {
            System.out.println("Entering Case #3");
            delete(node, word, index + 1);
            return false;
        }

        System.out.println("Entering Case #4");
        boolean canDeleteThisNode = delete(node, word, index + 1);
        if (canDeleteThisNode) {
            System.out.println("Character " + ch + " has no dependency, hence deleting it !");
            parent.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }


    public List<String> findWordsForPrefix(String prefix) {
        TrieNode node = root;

        char[] arr = prefix.toCharArray();

        List<String> words = new ArrayList<>();
        for (char c : arr) {
            TrieNode nextNode = node.children.get(c);
            if (nextNode == null) {
                return words;
            }
            node = nextNode;
        }


        if (node.children.isEmpty() && node.endOfWord) {
            words.add(prefix);
        } else {
            findAllWordsPrefixRecursive(prefix, node, words);
        }
        return words;
    }

    public void findAllWordsPrefixRecursive(String prefix, TrieNode node, List<String> words) {

        if (node.endOfWord) {
            words.add(prefix);
        }
        if (node.children.isEmpty()) {
            return;
        }

        for (char c : node.children.keySet()) {
            findAllWordsPrefixRecursive(prefix + c, node.children.get(c), words);
        }
    }

}
