package com.example.microsoft.practice;

public class LongestPalindrom {


    public static void main(String[] args) {
        System.out.println(new LongestPalindrom().longestPalindromicSubString("ABMALAYALAMXI", 0, 12));
    }


    int longestPalindromicSubString(String input, int start, int end) {

        if (start>end){
            return 0;
        }

        if (start == end){
            return 1;
        }

            int c1 = 0;

            if (input.charAt(start) == input.charAt(end)){
                int remaining = end-start-1;

                if (remaining == longestPalindromicSubString(input, start+1, end-1)){
                    c1 = remaining+2;
                }
            }

            int c2 = longestPalindromicSubString(input, start+1, end);

            int c3 = longestPalindromicSubString(input, start, end-1);



        return Math.max(c1, Math.max(c2, c3));
    }


}
