package com.jtemp.test.leetcode;

/**
 * Maximum Subarray 最大子数组
 * <p>
 * <p>
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p>
 * click to show more practice.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Chapter52MaxSubArray {

    public static void main(String[] args) {

        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ret = maxSubArray1(array);
        System.out.println(ret);
        ret = maxSubArray2(array);
        System.out.println(ret);
    }

    /**
     * 动态规划，节约空间解法
     *
     * @param array
     * @return
     */
    private static int maxSubArray2(int[] array) {
        int max = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     *
     * @param array
     * @return
     */
    private static int maxSubArray1(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
