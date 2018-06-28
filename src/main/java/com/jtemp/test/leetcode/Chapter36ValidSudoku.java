package com.jtemp.test.leetcode;

import java.util.BitSet;

/**
 * Valid Sudoku 验证数独
 * <p>
 * <p>
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p>
 * A partially filled sudoku which is valid.
 * <p>
 * <p>
 * <p>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Chapter36ValidSudoku {

    public static void main(String[] args) {

        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 4, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        boolean ret = isValidSudoku(sudoku);
        System.out.println(ret);

    }

    public static boolean isValidSudoku(int[][] sudoku) {

        for (int i = 0; i < 9; i++) {
            BitSet col = new BitSet();
            BitSet row = new BitSet();
            BitSet grid = new BitSet();
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != 0) {
                    if (row.get(sudoku[i][j])) {
                        return false;
                    } else {
                        row.set(sudoku[i][j]);
                    }
                }
                if (sudoku[j][i] != 0) {
                    if (col.get(sudoku[j][i])) {
                        return false;
                    } else {
                        col.set(sudoku[j][i]);
                    }
                }
                int r = i / 3 * 3 + j / 3;
                int c = i / 3 * 3 + j % 3;

//                System.out.println(String.format("(%s,%s)->(%s,%s)", i, j, r, c));
//
                if (sudoku[r][c] != 0) {
                    if (grid.get(sudoku[r][c])) {
                        return false;
                    } else {
                        grid.set(sudoku[r][c]);
                    }
                }
            }
        }
        return true;
    }

}
