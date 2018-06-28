package com.jtemp.test.collection;


import java.util.BitSet;

/**
 * 顺时针打印矩阵
 */
public class Demo9 {

    enum Direct {
        RIGHT(0, 1),
        DOWN(1, 0),
        LEFT(0, -1),
        UP(-1, 0);

        public final int r;
        public final int c;

        Direct(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private int[][] array;

    private Direct direct = Direct.RIGHT;

    private int row;
    private int col;

    BitSet marked = new BitSet();

    public Demo9(int[][] array) {
        this.array = array;
    }

    private void walkPrint() {
        while (!(isBlocked() && isBlockRight())) {
            print();
            moveForward();
            if (isBlocked()) {
                if (!isBlockRight()) {
                    turnRight();
                }
            }
        }
        print();
    }

    private void print() {
        System.out.println(array[row][col]);
        setMark(row, col);
    }

    private void setMark(int row, int col) {
        marked.set(row * array[0].length + col);
    }

    private boolean getMark(int row, int col) {
        return marked.get(row * array[0].length + col);
    }

    private void turnRight() {
        direct = rightDirect(direct);
    }

    private Direct rightDirect(Direct direct) {
        Direct ret = null;
        switch (direct) {
            case RIGHT:
                ret = Direct.DOWN;
                break;
            case DOWN:
                ret = Direct.LEFT;
                break;
            case LEFT:
                ret = Direct.UP;
                break;
            case UP:
                ret = Direct.RIGHT;
                break;
        }
        return ret;
    }

    private void moveForward() {
        row += direct.r;
        col += direct.c;
    }

    private boolean isBlockRight() {
        return isBlocked(rightDirect(direct));
    }

    private boolean isBlocked() {
        return isBlocked(direct);
    }

    private boolean isBlocked(Direct direct) {
        int r = row + direct.r;
        int c = col + direct.c;
        if (getMark(r, c)) {
            return true;
        }
        return r < 0 || c < 0 || r >= array.length || c >= array.length;
    }

    public static void main(String[] args) {

        int[][] array = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Demo9 demo9 = new Demo9(array);
        demo9.walkPrint();

        System.out.println("--------");

        print2(array);


    }

    private static void print2(int[][] array) {
        int r0 = 0;
        int r1 = array.length - 1;
        int c0 = 0;
        int c1 = array[0].length - 1;

        while (r0 <= r1 && c0 <= c1) {
            for (int c = c0; c <= c1; c++) {
                System.out.println(array[r0][c]);
            }
            for (int r = r0 + 1; r <= r1; r++) {
                System.out.println(array[r][c1]);
            }
            for (int c = c1 - 1; c >= c0; c--) {
                System.out.println(array[r1][c]);
            }
            for (int r = r1 - 1; r >= r0; r--) {
                System.out.println(array[r][c0]);
            }
            c0++;
            r0++;
            c1--;
            r1--;
        }

    }


}
