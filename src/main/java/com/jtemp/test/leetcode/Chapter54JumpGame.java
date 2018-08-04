package com.jtemp.test.leetcode;

/**
 * Jump Game 跳跃游戏
 * <p>
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class Chapter54JumpGame {

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4};

        System.out.println(canJumpLast(array));

    }

    /**
     * 贪心算法
     *
     * @param array
     * @return
     */
    private static boolean canJumpLast(int[] array) {
        int farthest = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > farthest) {
                break;
            }
            farthest = Math.max(farthest, i + array[i]);
        }
        return farthest >= array.length - 1;
    }


}
