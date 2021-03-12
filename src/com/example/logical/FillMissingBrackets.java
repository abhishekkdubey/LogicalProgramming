package com.example.logical;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FillMissingBrackets {


    public static void main(String[] args) {

    }


    public static int fillMissingBrackets(String s) {

        List<String> arr = new ArrayList<>();
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (idCompleteBrackets(s.substring(index, i))) {
                arr.add(s.substring(index, i));
            }
        }
        return -1;

    }


    private static boolean idCompleteBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {


        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
