package com.jtemp.test.leetcode;

import java.util.*;

/**
 * Merge Intervals 合并区间
 * <p>
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Chapter55MergeIntervals {

    public static void main(String[] args) {
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{5, 10});
        intervals.add(new int[]{15, 18});

        List<int[]> merged = merge(intervals);

        for (int[] ints : merged) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> merge(List<int[]> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o[1]));
        Stack<int[]> stack = new Stack<>();
        intervals.forEach(stack::push);
        List<int[]> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] first = stack.pop();
            if (stack.isEmpty()) {
                ret.add(first);
                break;
            }
            int[] second = stack.pop();
            if (isOverlapping(first, second)) {
                stack.push(merge(first, second));
            } else {
                ret.add(first);
                stack.push(second);
            }
        }
        return ret;
    }

    private static int[] merge(int[] first, int[] second) {
        return new int[]{Math.min(first[0], second[0]), Math.max(first[1], second[1])};
    }

    private static boolean isOverlapping(int[] first, int[] second) {
        return isInRange(first, second[0])
                || isInRange(first, second[1])
                || isInRange(second, first[0])
                || isInRange(second, first[1]);
    }

    private static boolean isInRange(int[] range, int value) {
        return range[0] <= value && range[1] >= value;
    }


}
