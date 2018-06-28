package com.jtemp.test.leetcode;

import java.util.Arrays;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Chapter2AddTwoNumbers {

    public static void main(String[] args) {

        int[] first   = {2, 9, 9};
        int[] another = {5, 9, 9};

        int[] ret = addTwoNumber(first, another);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] addTwoNumber(int[] first, int[] another) {
        int   maxLen = Math.max(first.length, another.length);
        int   minLen = Math.min(first.length, another.length);
        int[] ret    = new int[maxLen + 1];
        for (int i = 0; i < minLen; i++) {
            int v = first[i] + another[i];
            ret[i] += v % 10;
            ret[i + 1] = v / 10;
        }
        return ret;
    }

}
