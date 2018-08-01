package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * Rotate Image 旋转图像
 * <p>
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Follow up:
 * Could you do this in-place?
 */
public class Chapter48RotateImage {


    public static void main(String[] args) {

        int[][] image = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] ret = roteImage90Degrees(image);
        for (int[] ints : ret) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] roteImage90Degrees(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = i + 1; j < image.length; j++) {
                swap(image, i, j);
            }
            reverse(image[i]);
        }
        return image;
    }

    private static void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    private static void swap(int[][] image, int i, int j) {
        int tmp = image[i][j];
        image[i][j] = image[j][i];
        image[j][i] = tmp;
    }

}
