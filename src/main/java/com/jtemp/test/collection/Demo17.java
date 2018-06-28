package com.jtemp.test.collection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 连续子数组的最大和
 * {6,-3,-2,7,-15,1,2,2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class Demo17 {


    public static void main(String[] args) {
        int[] array = initIntArray();
//        int ret = subArrayMaxSum(array);
//        System.out.println(ret);
        System.out.println(FindGreatestSumOfSubArray(array));
    }

    public static int FindGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : nums) {
            sum = sum <= 0 ? val : sum + val;
            ret = Math.max(ret, sum);
        }
        return ret;
    }


    private static int subArrayMaxSum2(int[] array) {
        return subArrayMaxSum2(array, 0, array.length);
    }

    static int max = Integer.MIN_VALUE;
    static List<Integer> maxList = null;

    private static int subArrayMaxSum2(int[] array, int start, int end) {
        if (start > end || start < 0 || end < 0 || start >= array.length || end > array.length) {
            return 0;
        }
        if (start == end) {
            int val = array[start];
            if (val > max) {
                max = val;
            }
            return val;
        }
        int value = IntStream.of(array).skip(start).limit(end - start).sum();
        int value2 = subArrayMaxSum2(array, start + 1, end);
        int value3 = subArrayMaxSum2(array, start, end - 1);
        int ret = Math.max(value, Math.max(value2, value3));
        if (ret > max) {
            max = ret;
        }
        return ret;
    }

    private static int subArrayMaxSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int max = Integer.MIN_VALUE;
        List<Integer> maxList = null;
        for (int i = 0; i < array.length; i++) {
            int start = i;
            int end = array.length;
            while (start <= end) {
                int val = IntStream.of(array).skip(start).limit(end - start).sum();
                if (val > max) {
                    max = val;
                    maxList = IntStream.of(array).skip(start).limit(end - start).boxed().collect(Collectors.toList());
                }
                end--;
            }
        }
        System.out.println(maxList);
        return max;
    }

    private static int[] initIntArray() {
        return new int[]{1, -15, 1, -2, -2, -6, -3, -2, -7};
    }

}
