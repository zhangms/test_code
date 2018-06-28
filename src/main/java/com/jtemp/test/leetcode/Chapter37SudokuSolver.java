package com.jtemp.test.leetcode;

import java.util.Arrays;
import java.util.BitSet;

public class Chapter37SudokuSolver {


    public static void main(String[] args) {

        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        solver(sudoku);

        for (int[] array : sudoku) {
            System.out.println(Arrays.toString(array));
        }

    }

    private static void solver(int[][] sudoku) {

        if (!Chapter36ValidSudoku.isValidSudoku(sudoku)) {
            throw new RuntimeException("is not valid sudoku");
        }

        solver(sudoku, 0, 0);

    }

    private static boolean solver(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return true;
        }
        if (col >= 9) {
            return solver(sudoku, row + 1, 0);
        }
        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                sudoku[row][col] = i;
                if (isValid(sudoku, row, col)) {
                    if (solver(sudoku, row, col + 1)) {
                        return true;
                    }
                }
                sudoku[row][col] = 0;
            }
        } else {
            return solver(sudoku, row, col + 1);
        }
        return false;
    }

    private static boolean isValid(int[][] sudoku, int row, int col) {

        BitSet rowValid = new BitSet();
        BitSet colValid = new BitSet();
        BitSet gridValid = new BitSet();
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] != 0) {
                if (rowValid.get(sudoku[row][i])) {
                    return false;
                } else {
                    rowValid.set(sudoku[row][i]);
                }
            }
            if (sudoku[i][col] != 0) {
                if (colValid.get(sudoku[i][col])) {
                    return false;
                } else {
                    colValid.set(sudoku[i][col]);
                }
            }
            int c = col / 3 * 3 + i % 3;
            int r = row / 3 * 3 + i / 3;
            if (sudoku[r][c] != 0) {
                if (gridValid.get(sudoku[r][c])) {
                    return false;
                } else {
                    gridValid.set(sudoku[r][c]);
                }
            }
        }
        return true;
    }


}
