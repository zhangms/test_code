package com.jtemp.test.collection;

/**
 * 把 n 个骰子仍在地上，求点数和为 s 的概率。
 */
public class Demo30 {

    public static void main(String[] args) {

        int n = 10;
        int s = 20;

        double all = 0;
        for (int i = 3; i <= 18; i++) {
            all += rate(3, i);
        }
        System.out.println(all);
    }

    private static double rate(int n, int s) {
        if (s < n || s > n * 6) {
            return 0;
        }
        if (s == n || s == n * 6) {
            return 1.0 / Math.pow(6, n);
        }
        int c = count(n, s);
        return c / Math.pow(6, n);
    }

    private static int count(int n, int s) {
        if (n <= 0 || s <= 0) {
            return 0;
        }
        if (n == 1 && s <= 6) {
            return 1;
        }
        int ret = 0;
        for (int i = 1; i <= 6; i++) {
            ret += count(n - 1, s - i);
        }
        return ret;
    }

}
