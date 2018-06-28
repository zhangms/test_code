package com.jtemp.test.leetcode;


/**
 * Median of Two Sorted Arrays 两个有序数组的中位数
 * <p>
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Chapter4MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] array1 = {10, 11, 23, 50};
        int[] array2 = {8, 12, 15};
        System.out.println(median(array1, array2));

    }

    private static double median(int[] array1, int[] array2) {
//        int mergeLen = array1.length + array2.length;
//        int[] medianIndex = {-1, -1};
//        if (mergeLen % 2 != 0) {
//            medianIndex[0] = mergeLen / 2;
//        } else {
//            medianIndex[0] = mergeLen / 2;
//            medianIndex[1] = mergeLen / 2 - 1;
//        }
//        if (array1[array1.length - 1] < array2[0]) {
//            return median(array1, array2, medianIndex);
//        } else if (array1[0] > array2[array2.length - 1]) {
//            return median(array2, array1, medianIndex);
//        }
        int[] merge = new int[array1.length + array2.length];
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < array1.length && i2 < array2.length) {
            if (array1[i1] < array2[i2]) {
                merge[i] = array1[i1];
                i1++;
            } else {
                merge[i] = array1[i2];
                i2++;
            }
            i++;
        }
        while (i < array1.length) {
            merge[i] = array1[i];
            i++;
        }
        while (i < array2.length) {
            merge[i] = array1[i];
            i++;
        }
        return merge[merge.length / 2];
    }
}
