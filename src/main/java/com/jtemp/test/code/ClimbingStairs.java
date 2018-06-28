package com.jtemp.test.code;

public class ClimbingStairs {

    public static void main(String[] args) {

        int count = climbingStairs(4);
        System.out.println(count);

        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(climbingStairs2(cost, cost.length - 1));

        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));

        System.out.println(houseRobber(new int[]{1, 100, 200, 50, 70, 180}));
    }

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * Note: Given n will be a positive integer.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: 2
     * Output:  2
     * Explanation:  There are two ways to climb to the top.
     * <p>
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     * <p>
     * Input: 3
     * Output:  3
     * Explanation:  There are three ways to climb to the top.
     * <p>
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     * <p>
     * 爬楼梯
     */
    private static int climbingStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 746. Min Cost Climbing Stairs
     * <p>
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     * <p>
     * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the
     * <p>
     * floor, and you can either start from the step with index 0, or the step with index 1.
     * <p>
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * Example 2:
     * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * Output: 6
     * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     * Note:
     * cost will have a length in the range [2, 1000].
     */
    static int climbingStairs2(int[] cost, int index) {
//        if (index < 0) {
//            return 0;
//        }
//        if (index == 0) {
//            return cost[0];
//        }
//        if (index == 1) {
//            return Math.min(cost[0], cost[1]);
//        }
//        return Math.min(climbingStairs2(cost, index - 1), climbingStairs2(cost, index - 2)) + cost[index];


        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return dp[cost.length - 1];
    }

    static int maxSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + array[i];
        }

        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * 198. House Robber
     * <p>
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed,
     * the only constraint stopping you from robbing each of them is that adjacent houses
     * have security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     * <p>
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     */

    public static int houseRobber(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 2] + array[i], dp[i - 1]);
        }
        return dp[array.length - 1];
    }

}
