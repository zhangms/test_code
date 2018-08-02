package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * Spiral Matrix 螺旋矩阵
 * <p>
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Chapter53SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 8, 9, 12},
                {13, 14, 15, 16}
        };

        int[] ret = spiralMatrix(matrix);

        System.out.println(Arrays.toString(ret));
    }

    enum Walk {
        RIGHT(0, 1, "DOWN"),
        DOWN(1, 0, "LEFT"),
        LEFT(0, -1, "UP"),
        UP(-1, 0, "RIGHT");

        int    dr;
        int    dc;
        String next;

        Walk(int dr, int dc, String next) {
            this.dr = dr;
            this.dc = dc;
            this.next = next;
        }

        public Walk next() {
            return Walk.valueOf(next);
        }
    }

    private static int[] spiralMatrix(int[][] matrix) {
        int[] ret = new int[matrix.length * matrix[0].length];

        int[] rRange = new int[]{0, matrix.length - 1};
        int[] cRange = new int[]{0, matrix[0].length - 1};
        int r = rRange[0];
        int c = cRange[0];

        int i = 0;

        Walk walk = Walk.RIGHT;
        while (cRange[1] >= cRange[0] && rRange[1] >= rRange[0]) {
            ret[i] = matrix[r][c];
            int rNext = r + walk.dr;
            int cNext = c + walk.dc;
            if (rNext >= rRange[0] && rNext <= rRange[1] && cNext >= cRange[0] && cNext <= cRange[1]) {
                c = cNext;
                r = rNext;
                i++;
            } else {
                switch (walk) {
                    case RIGHT:
                        rRange[0]++;
                        break;
                    case DOWN:
                        cRange[1]--;
                        break;
                    case LEFT:
                        rRange[1]--;
                        break;
                    case UP:
                        cRange[0]++;
                        break;
                }
                walk = walk.next();
            }
        }

        return ret;
    }


}
