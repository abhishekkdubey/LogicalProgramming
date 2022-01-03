package com.example.microsoft.practice;

public class MinimumCostProblem {

    public static void main(String[] args) {


        int[][] array =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };

        System.out.println(minimumCostFromStartToEndOf2DArray(array, 4, 4));
    }



    private static int minimumCostFromStartToEndOf2DArray(int[][] arr, int row, int column){
        if (row==-1||column == -1){
            return Integer.MAX_VALUE;
        }

        if (row ==0 && column ==0){
            return arr[0][0];
        }

        int cost1 = minimumCostFromStartToEndOf2DArray(arr, row-1, column);
        int cost2 = minimumCostFromStartToEndOf2DArray(arr, row, column-1);

        int minimum = Math.min(cost1, cost2);

        int currentCellCost = arr[row][column];

        return minimum+currentCellCost;

    }
}
