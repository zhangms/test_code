package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II 组合之和之二
 * <p>
 * <p>
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class Chapter40CombinationSumII {

    public static void main(String[] args) {

        int[] array = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> ret = combinationSum(array, target);
        System.out.println(ret);
    }

    private static List<List<Integer>> combinationSum(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum(array, 0, target, ret, new ArrayList<>());
        return ret;
    }

    private static void combinationSum(int[] array, int start, int target, List<List<Integer>> ret, ArrayList<Integer> path) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < array.length; i++) {
                if (i > start && array[i] == array[i - 1]) {
                    continue;
                }
                path.add(array[i]);
                combinationSum(array, i + 1, target - array[i], ret, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
