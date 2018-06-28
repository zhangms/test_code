package com.jtemp.test.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Chapter1TwoSum {

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSum1(array, target);
        System.out.println(Arrays.toString(ret));
        ret = twoSum2(array, target);
        System.out.println(Arrays.toString(ret));
    }

    /**
     * 时间复杂度O(n^2)
     *
     * @param array
     * @param target
     * @return
     */
    private static int[] twoSum1(int[] array, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 空间换时间，时间复杂度O(n),空间复杂度O(n)
     *
     * @param array
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int other = target - array[i];
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(array[i], i);
        }
        return null;
    }

}
