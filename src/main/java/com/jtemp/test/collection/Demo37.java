package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口最大值
 */
public class Demo37 {


    public static void main(String[] args) {

        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};
        int n = 3;

        int[] ret = maxInSlideWindow(array, n);

        System.out.println(Arrays.toString(ret));

    }

    private static int[] maxInSlideWindow(int[] array, int n) {
        if (n <= 0 || array == null || array.length == 0) {
            return null;
        }
        if (n >= array.length) {
            return new int[]{Arrays.stream(array).max().getAsInt()};
        }
        List<Integer> ret = new ArrayList<>();

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

}
