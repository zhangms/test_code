package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，
 * 那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
 */
public class Demo27 {


    public static void main(String[] args) {

        int[] array = {2, 3, 4, 2, 6, 2, 5, 1};

        int window = 3;

        System.out.println(maxInSlideWindow(array, window));

    }

    private static List<Integer> maxInSlideWindow(int[] array, int window) {
        if (array == null || window > array.length || window < 0) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= array.length - window; i++) {
            int max = array[i];
            for (int j = i + 1; j < i + window; j++) {
                max = Math.max(max, array[j]);
            }
            ret.add(max);
        }
        return ret;
    }

}
