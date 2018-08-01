package com.jtemp.test.leetcode;

/**
 * Pow(x, n) 求x的n次方
 * <p>
 * <p>
 * Implement pow(x, n).
 * 折半思想
 */
public class Chapter50PowerXN {

    public static void main(String[] args) {

        double x = myPower(5, 8);
        System.out.println(x);

    }

    private static double myPower(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return power(x, n);
        }
        return 1 / power(x, -n);
    }

    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }


}
