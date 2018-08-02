package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-Queens N皇后问题
 * <p>
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * <p>
 * 不能攻击是指，任意两个皇后，不能处在同一行，同一列，以及同一斜线上
 */
public class Chapter51NQueens {

    public static void main(String[] args) {

        List<int[]> ret = solveNQueens(8);
        System.out.println(ret.size());
        for (int[] ints : ret) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> solveNQueens(int n) {
        List<int[]> ret = new ArrayList<>();
        int[] pos = new int[n];
        solveNQueens(ret, pos, 0, n);
        return ret;
    }

    private static boolean isValid(int[] pos, int row) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == pos[row]) {
                return false;
            }
            if (Math.abs(pos[i] - pos[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private static void solveNQueens(List<int[]> ret, int[] pos, int row, int n) {
        if (row >= n) {
            if (isValid(pos, n - 1)) {
                ret.add(Arrays.copyOf(pos, pos.length));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            pos[row] = i;
            if (isValid(pos, row)) {
                solveNQueens(ret, pos, row + 1, n);
            }
        }
    }

}
