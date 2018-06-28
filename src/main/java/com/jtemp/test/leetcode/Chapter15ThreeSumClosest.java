package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * 3Sum Closest 最近三数之和
 * <p>
 * <p>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Chapter15ThreeSumClosest {

    public static void main(String[] args) {

        int[] array = {-1, 2, 1, -4};
        int target = 1;
        Integer ret = threeSumClosest(array, target);
        System.out.println(ret);
    }

    private static Integer threeSumClosest(int[] array, int target) {
        if (array == null || array.length < 3) {
            return null;
        }
        if (array.length == 3) {
            return array[0] + array[1] + array[2];
        }
        Arrays.sort(array);
        int closest = array[0] + array[1] + array[2];
        int diff = Math.abs(closest - target);
        for (int i = 0; i < array.length; i++) {
            int start = i + 1;
            int end = array.length - 1;
            while (start < end) {
                int sum = array[i] + array[start] + array[end];
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                int nowDiff = Math.abs(sum - target);
                if (nowDiff < diff) {
                    closest = sum;
                    diff = nowDiff;
                }
            }
        }
        return closest;
    }

}
