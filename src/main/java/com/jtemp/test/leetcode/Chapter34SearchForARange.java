package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * Search for a Range 搜索一个范围
 * <p>
 * <p>
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class Chapter34SearchForARange {

    public static void main(String[] args) {

        int[] array = {5, 7, 7, 8, 8, 10};

        int target = 5;

        int[] ret = searchRange(array, target);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] searchRange(int[] array, int target) {
        int[] ret = new int[]{-1, -1};
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                for (int i = mid; i >= 0; i--) {
                    if (array[i] == target) {
                        ret[0] = i;
                    }
                }
                for (int i = mid; i <= right; i++) {
                    if (array[i] == target) {
                        ret[1] = i;
                    }
                }
                break;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

}
