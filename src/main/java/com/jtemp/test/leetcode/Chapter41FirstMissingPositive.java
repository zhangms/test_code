package com.jtemp.test.leetcode;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Chapter41FirstMissingPositive {

    public static void main(String[] args) {

        int[] array = {3, 4, -1, 1};

        int ret = findFirstMissingPositive(array);
        System.out.println(ret);
    }

    private static int findFirstMissingPositive(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            if (v >= 0) {
                if (v < array.length) {
                    array[i] = array[v];
                    array[v - 1] = v;
                } else {
                    array[i] = -1;
                }
            }
        }
//        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

}
