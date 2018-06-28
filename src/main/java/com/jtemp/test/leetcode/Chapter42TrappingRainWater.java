package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * Trapping Rain Water 收集雨水
 * <p>
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * <p>
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class Chapter42TrappingRainWater {

    public static void main(String[] args) {

        int[] array = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ret = trappingRainWater(array);
        System.out.println(ret);
    }

    private static int trappingRainWater(int[] array) {

        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < array.length; i++) {
            dp[i] = dp[i - 1] + Math.min(array[i], array[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

}
