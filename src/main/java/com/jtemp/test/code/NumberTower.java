package com.jtemp.test.code;


import java.util.Arrays;

/**
 * 数塔
 * <pre>
 *
 *                             13
 *                            /  \
 *                           11   8
 *                          /  \ / \
 *                        12    7  26
 *                       /  \  / \ / \
 *                      6    14  15  8
 *                     / \   / \ / \ / \
 *                     12  7   13   24  11
 * </pre>
 * 从上走到下，找出路径中和的最大值
 */

public class NumberTower {

    public static void main(String[] args) {

        int[][] tower = {
                {13, 0, 0, 0, 0},
                {11, 8, 0, 0, 0},
                {12, 7, 26, 0, 0},
                {6, 14, 15, 8, 0},
                {12, 7, 13, 24, 11}
        };
        int n = tower.length;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {//最底层
            dp[n - 1][i] = tower[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + tower[i][j];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(Arrays.toString(dp[i]));
            System.out.println(Arrays.toString(tower[i]));
        }
    }

}
