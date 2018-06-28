package com.jtemp.test.collection;


import java.util.BitSet;

/**
 * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，
 * 每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 * 例如，当 k 为 18 时，机器人能够进入方格（35, 37），因为 3+5+3+7=18。但是，它不能进入方格（35, 38），
 * 因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
 */
public class Demo5 {

    static class Map {
        int rows;
        int cols;
        int blockHeight;

        BitSet mapData;

        public Map(int rows, int cols, int blockHeight) {
            this.rows = rows;
            this.cols = cols;
            if (rows <= 0 || cols <= 0) {
                throw new IllegalArgumentException(String.format("rows:%s,cols:%s", rows, cols));
            }
            this.blockHeight = blockHeight;
            initMap();
        }

        private void initMap() {
            mapData = new BitSet();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int index = i * cols + j;
                    int height = calHeight(i) + calHeight(j);
                    if (height > blockHeight) {
                        mapData.set(index);
                    }
                }
            }
        }

        public boolean isBlock(int r, int c) {
            return mapData.get(r * cols + c);
        }

        private int calHeight(int num) {
            int val = 0;
            while (num > 0) {
                val += num % 10;
                num /= 10;
            }
            return val;
        }
    }

    public static void main(String[] args) {
        Map map = new Map(10, 10, 17);
        checkArrived(map);
    }

    private static void checkArrived(Map map) {
        BitSet mark = new BitSet();
        checkArrived(map, mark, 0, 0);
        System.out.println(mark.cardinality());
    }

    private static void checkArrived(Map map, BitSet mark, int row, int col) {
        if (row < 0 || col < 0
                || row >= map.rows || col >= map.cols //超出地图范围
                ) {
            return;
        }
        if (mark.get(row * map.cols + col)) {
            return;
        }
        if (map.isBlock(row, col)) {
            return;
        }
        mark.set(row * map.cols + col);

        checkArrived(map, mark, row + 1, col);
        checkArrived(map, mark, row - 1, col);
        checkArrived(map, mark, row, col - 1);
        checkArrived(map, mark, row, col + 1);


    }

}
