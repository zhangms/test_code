package com.jtemp.test.collection;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 */
public class Demo23 {


    public static void main(String[] args) {

        System.out.println(getUglyNumber(20));
//        for (int i = 1; i < 200; i++) {
//            if (i % 20 == 0) {
//                System.out.println();
//            }
//        }

    }

    private static int getUglyNumber(int index) {
        if (index < 6) {
            return index;
        }
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int n2 = dp[i2] * 2, n3 = dp[i3] * 3, n5 = dp[i5] * 5;

            dp[i] = Math.min(n2, Math.min(n3, n5));

            if (dp[i] == n2) {
                i2++;
            }
            if (dp[i] == n3) {
                i3++;
            }
            if (dp[i] == n5) {
                i5++;
            }
        }
        System.out.println(IntStream.of(dp).boxed().collect(Collectors.toList()));
        return dp[index - 1];
    }
}
