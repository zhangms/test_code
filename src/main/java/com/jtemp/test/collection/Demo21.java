package com.jtemp.test.collection;

/**
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * <p>
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * <p>
 * 动态规划
 */
public class Demo21 {

    public static void main(String[] args) {
        int[][] array = initArray();

        int maxValue = calcMaxMaxValue(array);
        System.out.println(maxValue);

    }

    private static int calcMaxMaxValue(int[][] array) {
        return calcMaxValue(array, array.length - 1, array[0].length - 1);
    }

    private static int calcMaxValue(int[][] array, int r, int c) {
        if (r < 0 || c < 0) {
            return 0;
        }

        int[] left = {0, -1};
        int[] up = {-1, 0};
        return array[r][c] + Math.max(
                calcMaxValue(array, r + left[0], c + left[1]),
                calcMaxValue(array, r + up[0], c + up[1])
        );
    }

    private static int[][] initArray() {
        return new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5},
        };
    }

}
