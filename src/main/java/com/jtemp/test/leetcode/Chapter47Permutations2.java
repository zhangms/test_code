package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Permutations II 全排列之二
 * <p>
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Chapter47Permutations2 {


    public static void main(String[] args) {
        List<List<Integer>> ret = permutations(new int[]{1, 1, 2});
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
                if (i != start && array[start] == array[i]) {
                    continue;
                }
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
