package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum 组合之和
 * <p>
 * <p>
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * <p>
 * <p>
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Chapter39CombinationSum {

    public static void main(String[] args) {

        int[] array = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ret = combinationSum(array, target);
        System.out.println(ret);
    }

    private static List<List<Integer>> combinationSum(int[] array, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        combinationSum(array, 0, target, ret, new ArrayList<Integer>());

        return ret;
    }

    private static void combinationSum(int[] array, int start, int target, List<List<Integer>> ret, ArrayList<Integer> path) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < array.length; i++) {
                path.add(array[i]);
                combinationSum(array, i, target - array[i], ret, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
