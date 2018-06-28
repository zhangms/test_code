package com.jtemp.test.leetcode;


/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class Chapter7ReverseInteger {

    public static void main(String[] args) {
        int number = 123;
        long ret = reverseInt(number);
        System.out.println(ret);
    }

    private static long reverseInt(int number) {
        boolean neg = number < 0;
        if (neg) {
            number *= -1;
        }
        long ret = 0;
        while (number > 0) {
            ret = ret * 10 + number % 10;
            number = number / 10;
        }
        return neg ? -ret : ret;
    }

}
