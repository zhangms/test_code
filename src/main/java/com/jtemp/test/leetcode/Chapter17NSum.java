package com.jtemp.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 4Sum 四数之和
 * <p>
 * <p>
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * <p>
 * <p>
 * 引申成n sum吧
 */
public class Chapter17NSum {

    public static void main(String[] args) {

        int n = 4;
        int target = 0;
        int[] array = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> ret = new ArrayList<>();
        nSum(array, 0, n, target, new ArrayList<>(), ret);
        System.out.println(ret);
    }

    private static void nSum(int[] array, int start, int n, int target, ArrayList<Integer> path, List<List<Integer>> ret) {
        if (n == 0) {
            if (target == 0) {
                ret.add(new ArrayList<>(path));
            }
        } else {
            for (int i = start; i < array.length; i++) {
                int v = array[i];
                path.add(v);
                nSum(array, i + 1, n - 1, target - v, path, ret);
                path.remove(path.size() - 1);
            }
        }

    }


}
