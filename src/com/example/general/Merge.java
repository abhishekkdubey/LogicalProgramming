package com.example.general;

import java.util.Arrays;
import java.util.LinkedList;

public class Merge {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Merge().mergeSortedArray(new int[]{1, 7, 9, 11, 17}, new int[]{3, 6, 10, 12, 15})));
    }


    public int[] mergeSortedArray(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;

        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        for (; i < a.length; i++) {
            result[k] = a[i];
            k++;
        }

        for (; j < b.length; j++) {
            result[k] = b[j];
            k++;
        }
        return result;

    }


    class Person{

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

}
