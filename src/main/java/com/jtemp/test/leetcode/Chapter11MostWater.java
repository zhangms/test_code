package com.jtemp.test.leetcode;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Container With Most Water 装最多水的容器
 * <p>
 * <p>
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container.
 */
public class Chapter11MostWater {

    public static void main(String[] args) {

        int[] array = initArray();
        System.out.println(Arrays.toString(array));

        int[] ret = mostWater(array);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] mostWater(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{0, 0, 0};
        }

        int start = 0;
        int end = array.length - 1;
        int[] ret = new int[3];
        while (start < end) {
            int val = Math.min(array[start], array[end]) * (end - start);
            if (val > ret[0]) {
                ret[0] = val;
                ret[1] = start;
                ret[2] = end;
            }
            if (array[start] > array[end]) {
                end--;
            } else {
                start++;
            }
        }

        return ret;
    }

    private static int[] initArray() {
        int len = 10;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            ret[i] = ThreadLocalRandom.current().nextInt(10);
        }
        return ret;
    }

}
