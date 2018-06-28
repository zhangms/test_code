package com.jtemp.test.leetcode;

/**
 * String to Integer (atoi) 字符串转为整数
 * <p>
 * <p>
 * Implement atoi to convert a string to an integer.
 * <p>
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p>
 * spoilers alert... click to show requirements for atoi.
 * <p>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Chapter8Atoi {

    public static void main(String[] args) {

        int ret = atoi("99999923");
        System.out.println(ret);

    }

    private static int atoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean neg = false;
        int start = 0;
        if (s.charAt(0) == '-') {
            neg = true;
            start = 1;
        } else if (s.charAt(0) == '+') {
            start = 1;
        }
        int ret = 0;
        for (int i = start; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            if (c >= 0 && c <= 9) {
                ret = ret * 10 + c;
                if (ret < 0) {
                    return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                throw new IllegalArgumentException("is not integer");
            }
        }
        return neg ? -ret : ret;
    }

}
