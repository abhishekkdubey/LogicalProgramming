package com.example.practice;

public class Grid {

    public static void main(String[] args) {

        dfs(0, 0, 0);
        System.out.println(answer);
        System.out.println();
        System.out.println(findPath("????U???????????D???????????????????????????????"));
    }


    //{'D','U','U', 'R','L','L','L','L','L','L','L','L','R','R','R','R','R','R','U','U','U','U','U','D','D','D','D','D'}


    private static int findPath(String input) {
        //Convert String to Array
        char[] arr = input.toCharArray();

        char currentPath = 0;
        int pathCount = 0;

        int count = 0;

        for (int i = 0; i < 7; i++) {

            for (int j = 0; j < 7; j++) {

                if (count < arr.length) {
                    if (arr[count] == '?') {

                        currentPath = arr[count];

                        if ((i == 0 && j == 0) || (i == 6 && j == 0) || (i == 0 && j == 6) || (i == 6 && j == 6)) {
                            pathCount += 2;
                        } else if (i == 0 || j == 0 || j == 6 || i == 6) {
                            pathCount += 3;
                        } else {
                            pathCount += 4;
                        }

                    } else if (arr[count] != currentPath) {
                        currentPath = arr[count];
                        pathCount++;
                    }
                }
                count++;

            }

        }
        return pathCount;
    }


    static boolean[][] visited = new boolean[7][7];
    static char[] path = "????U???????????D???????????????????????????????".toCharArray();
    static int answer = 0;

    private static boolean valid(int i, int j) {

        if (i < 7 && j < 7 && i >= 0 && j >= 0 && !visited[i][j]) {
            return true;
        }


        return false;
    }

    int numberOfPath(String input) {
        boolean[][] visited = new boolean[7][7];
        char[] path = input.toCharArray();
        int answer = 0;

        return answer;
    }

    static void dfs(int i, int j, int a) {
        //dbg(i, j, a);

        if (i == 6 && j == 0) {
            if (a == 48) {
                answer++;
            }
            return;
        }

        visited[i][j] = true;

        // go up
        if ((path[a] == 'U' || path[a] == '?')) {
            if (i > 0 && valid(i - 1, j)) {
                if (!(
                        !valid(i - 2, j)
                                && valid(i - 1, j - 1)
                                && valid(i - 1, j + 1))
                        || (i - 1 == 6 && j == 0)) {
                    dfs(i - 1, j, a + 1);
                }
            }
        }

        if (path[a] == 'D' || path[a] == '?') {
            if (i < 6 && valid(i + 1, j)) {
                if (!(

                        !valid(i + 2, j)
                                && valid(i + 1, j - 1)
                                && valid(i + 1, j + 1)
                )
                ) {
                    dfs(i + 1, j, a + 1);
                }
            }
        }

        if (path[a] == 'L' || path[a] == '?') {
            if (j > 0 && valid(i, j - 1)) {
                if (!(
                        !valid(i, j - 2)
                                && valid(i - 1, j - 1)
                                && valid(i + 1, j - 1))) {
                    dfs(i, j - 1, a + 1);
                }
            }
        }

        if (path[a] == 'R' || path[a] == '?') {
            if (j < 6 && valid(i, j + 1)) {
                if (!(
                        !valid(i, j + 2)
                                && valid(i - 1, j + 1)
                                && valid(i + 1, j + 1))) {
                    dfs(i, j + 1, a + 1);
                }
            }
        }

        visited[i][j] = false;
    }


}
