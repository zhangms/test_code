package com.jtemp.test.leetcode;


/**
 * Search in Rotated Sorted Array 在旋转有序数组中搜索
 * <p>
 * <p>
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class Chapter33SearchInRotatedSortedArray {

    public static void main(String[] args) {

        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int target = 1;

        int index = find(array, target);
        System.out.println(index);

    }

    private static int find(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < array[right]) {
                if (array[mid] < target && array[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (array[left] <= target && target <= array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
