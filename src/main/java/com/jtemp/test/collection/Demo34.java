package com.jtemp.test.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 长度为n的绳子剪成m段，让乘积最大
 */
public class Demo34 {

    static class Step {
        int value;
        List<Integer> cut = new ArrayList<>();

        public Step(int value) {
            this.value = value;
        }

        public Step add(Integer i) {
            cut.add(i);
            return this;
        }

        public Step addAll(Step mStep) {
            if (mStep != null) {
                cut.addAll(mStep.cut);
            }
            return this;
        }

        @Override
        public String toString() {
            return value + ":" + cut.toString();
        }
    }

    static int[] length = new int[3];

    public static void main(String[] args) {
        System.out.println(cutRope(10, 3));
    }

    private static Step cutRope(int n, int m) {
        if (m <= 0) {
            return null;
        }
        if (m > n) {
            return null;
        }
        if (m == 1) {
            return new Step(n).add(n);
        }
        int max = 0;
        Step mStep = null;
        int mLen = 0;
        for (int i = 1; i <= n - 1; i++) {
            Step step = cutRope(n - i, m - 1);
            if (step != null && step.value * i > max) {
                max = step.value * i;
                mStep = step;
                mLen = i;
            }
        }
        Step ret = new Step(max);
        ret.addAll(mStep);
        ret.add(mLen);
        return ret;
    }

}
