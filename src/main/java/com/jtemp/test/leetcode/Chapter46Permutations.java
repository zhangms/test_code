package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Permutations 全排列
 * <p>
 * <p>
 * Given a collection of numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Chapter46Permutations {


    public static void main(String[] args) {
        List<List<Integer>> ret = permutations(new int[]{1, 2, 3});
        System.out.println(ret);

    }

    private static List<List<Integer>> permutations(int[] array) {
        List<List<Integer>> ret = new ArrayList<>();
        permutations(array, 0, ret);
        return ret;
    }

    private static void permutations(int[] array, int start, List<List<Integer>> ret) {
        if (start >= array.length) {
            ret.add(IntStream.of(array).boxed().collect(Collectors.toList()));
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permutations(array, start + 1, ret);
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
