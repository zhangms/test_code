package com.jtemp.test.collection;

public class Demo2 {


    public static void main(String[] args) {

        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };


        for (int i = 0; i < 32; i++) {
            int[] loc = find(array, i);
            System.out.println(String.format("find %s in array location %s,%s", i, loc[0], loc[1]));
            System.out.println();
        }

    }

    private static int[] find(int[][] array, int num) {

        int rows = array.length;
        int cols = array[0].length;

        if (num < array[0][0] || num > array[rows - 1][cols - 1]) {
            return new int[]{-1, -1};
        }

        int r = 0;
        int c = cols - 1;

        while (r < rows && c > 0) {
            int d = num - array[r][c];
            if (d == 0) {
                return new int[]{r, c};
            } else if (d > 0) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};

    }

}
