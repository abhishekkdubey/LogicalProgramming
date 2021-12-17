package com.example.hashing;

public class Hashing {

    public static void main(String[] args) {

        System.out.println(smod(500));
        System.out.println(smod(700));
        System.out.println(sascii("ABCDEF..XYZ", 16));
        System.out.println(sascii("abcd..xyz", 16));

    }


    public static int sascii(String string, int M) {
        char[] chars = string.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < chars.length; i++) {
            System.out.println("Character " + chars[i] + " ascii value is " + (int) chars[i]);
            sum += chars[i];
        }
        return sum % M;
    }

    public static int smod(int M) {
        return M % 16;
    }
}
