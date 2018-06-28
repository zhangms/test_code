package com.jtemp.test.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Chapter14ThreeSum {

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSum(array);
        System.out.println(ret);
    }

    private static List<List<Integer>> threeSum(int[] array) {
        if (array == null || array.length < 3) {
            return null;
        }
        Arrays.sort(array);
        if (array[0] > 0) {
            return null;
        }
        if (array[0] == 0) {
            if (array[1] == 0 && array[2] == 0) {
                return Collections.singletonList(Arrays.asList(0, 0, 0));
            }
            return null;
        }

        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if (a > 0) {
                break;
            }
            int[] bc = twoSum(array, i + 1, -a);
            if (bc != null) {
                ret.add(Arrays.asList(a, bc[0], bc[1]));
            }
        }

        return ret;
    }

    private static int[] twoSum(int[] array, int index, int target) {

        int start = index;
        int end = array.length - 1;
        while (start < end) {
            int val = array[start] + array[end];
            if (val == target) {
                return new int[]{array[start], array[end]};
            } else if (val > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }
}
