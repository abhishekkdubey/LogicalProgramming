package com.example;


import java.math.BigInteger;
import java.util.*;

public class Test {

    public static void main(String[] args) {


        bigSum(30);

        System.out.println(timeFormat("07:05:45PM"));

    }


    public static void bigSum(int n) {

        BigInteger bInt= new BigInteger("1");

        int size = n+1;
        for (int i = 1; i < size; i++) {
                bInt= bInt.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bInt);

    }

    public static void roudUp(float value) {

        System.out.println(String.format("%.06f", value));
    }


    public static String timeFormat(String str) {

        StringBuilder sb = new StringBuilder();


        int hh = Integer.parseInt(str.substring(0, 2));
        // Get hours
        int h1 = (int) str.charAt(1) - '0';
        int h2 = (int) str.charAt(0) - '0';
//        int hh = (h2 * 10 + h1 % 10);


        // If time is in "AM"
        if (str.charAt(8) == 'A') {
            if (hh == 12) {
                sb.append("00");
                for (int i = 2; i <= 7; i++)
                    sb.append(str, 0, 5);
            } else {
                for (int i = 0; i <= 7; i++)
                    sb.append(str.charAt(i));
            }
        }

        // If time is in "PM"
        else {
            if (hh == 12) {
                sb.append("12");
                for (int i = 2; i <= 7; i++)
                    sb.append(str.charAt(i));
            } else {
                hh = hh + 12;
                System.out.print(hh);
                for (int i = 2; i <= 7; i++)
                    sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }


    public static List<Integer> rearrange(List<Integer> element) {
        Collections.sort(element, new IntComparator());

        System.out.println(element);
        return element;
    }


    static class IntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {

            int aCount = get1s(Integer.toBinaryString(a));
            int bCount = get1s(Integer.toBinaryString(b));
            if (aCount == bCount) {
                return a - b;
            } else {
                return aCount - bCount;
            }
        }
    }


    static int get1s(String str) {
        char nums[] = str.toCharArray();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                count++;
            }
        }
        return count;
    }

}


