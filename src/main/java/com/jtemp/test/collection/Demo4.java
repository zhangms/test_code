package com.jtemp.test.collection;


import java.util.Arrays;

/**
 * 1.一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 2.一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class Demo4 {

    static int jump1(int n) {
        if (n <= 1) {
            return 1;
        }
        return jump1(n - 1) + jump1(n - 2);
    }

    static int jump2(int n) {
//        return (int) Math.pow(2,n-1);
        if (n <= 1) {
            return 1;
        }
        int value = 0;
        for (int i = 0; i < n; i++) {
            value += jump2(i);
        }
        return value;
    }

    public static int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public static void main(String[] args) {
//        System.out.println(jump1(3));
//        for (int i = 1; i < 100; i++) {
//            int a = jump2(i);
//            int b = jumpFloorII(i);
//            if (a != b) {
//                System.out.println(i);
//            }
//        }

        System.out.println(sum(12345));

    }

    static int sum(int i) {
        if (i < 10) {
            return i;
        }
        return sum(i/10) + (i % 10);
    }

}
