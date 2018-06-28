package com.jtemp.test.collection;

/**
 * 题目描述：判断一个数是否为两个数的平方和，例如 5 = 12 + 22。
 */
public class Demo32 {

    public static void main(String[] args) {

        int n = 28;

        System.out.println(judgeSquareSum(n));

    }

    private static boolean judgeSquareSum(int n) {

        int i = 0;
        int j = (int) Math.sqrt(n);

        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == n) {
                System.out.println(i + "," + j);
                return true;
            } else if (sum > n) {
                j--;
            } else if (n > sum) {
                i++;
            }
        }
        return false;
    }

}
