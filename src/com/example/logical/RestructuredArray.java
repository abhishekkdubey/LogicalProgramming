package com.example.logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestructuredArray {

    public static void main(String[] args) {

        getElement(Arrays.asList(new Integer[]{5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), null);
    }


    public static List<Integer> getElement(List<Integer> arr, List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();

        if (arr != null && arr.size() > 1) {
            int column = arr.get(0);
            int row = arr.size() / column;
            int[][] twoDimenArray = new int[row][column];

            //Fill the 2D Array
            int index = 0;
            for (int r = 1; r <= row; r++) {
                for (int i = 1; i <= column; i++) {
                    twoDimenArray[r - 1][i - 1] = arr.get(index + i);
                }
                index += column;
            }
            for (int r = 0; r <= queries.size(); r++) {
                List<Integer> subList = queries.get(r);
//                if (subList.size() > 1 && subList.get(0)<=) {
//                    result.add(twoDimenArray[subList.get(0)-1][subList.get(1)]);
//                }
            }
        }

        return result;
    }

    public static void print2D(int mat[][]) {
        // Loop through all rows
        for (int[] row : mat)
            // Loop through all columns of current row
            for (int x : row)
                System.out.print(x + " ");
        System.out.println("");
    }

}
