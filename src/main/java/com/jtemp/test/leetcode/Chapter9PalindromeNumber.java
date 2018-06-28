package com.jtemp.test.leetcode;

/**
 * Palindrome Number 验证回文数字
 * <p>
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class Chapter9PalindromeNumber {

    public static void main(String[] args) {

        boolean ret = isPalindromeNumber(123);
        System.out.println(ret);
    }


    private static boolean isPalindromeNumber(int number) {
        if (number < 0) {
            return false;
        }
        if (number < 10) {
            return true;
        }
        return reverseInteger(number) == number;
    }

    private static int reverseInteger(int number) {
        int ret = 0;
        while (number > 0) {
            ret = ret * 10 + number % 10;
            if (ret < 0) {
                return 0;
            }
            number = number / 10;
        }
        return ret;
    }

}
