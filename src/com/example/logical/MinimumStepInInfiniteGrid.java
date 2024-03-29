package com.example.logical;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * <p>
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * <p>
 * Input :
 * <p>
 * Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
 * Output :
 * <p>
 * Return an Integer, i.e minimum number of steps.
 * Example :
 * <p>
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * <p>
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 */
public class MinimumStepInInfiniteGrid {

    public static void main(String[] args) {
        System.out.println(coverPoint(new int[]{-7, -13}, new int[]{1, -5}));

    }

    private static int coverPoint(int[] A, int[] B) {




        return 0;

    }

}
